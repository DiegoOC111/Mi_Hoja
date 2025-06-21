B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Private ListaDoctores As CustomListView
	Private Spiner_especialidad As Spinner
	Private xui As XUI
	Private doctoresList As List
	Private Lbl_nombre As Label
	Private Lbl_especialidad As Label
	Private IMG_Doc As ImageView
	Private DoctorSeleccionado As Map
	Dim FechaSeleccionada As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("VistaElegirHora")
    
	CargarDoctores
	LlenarSpinner
	Spiner_especialidad.SelectedIndex = 0 ' Disparar selección inicial
End Sub

Sub CargarDoctores
	Dim ruta As String = File.DirInternal
	Dim nombreArchivo As String = "doctores.json"
    
	If File.Exists(ruta, nombreArchivo) = False Then
		ToastMessageShow("Archivo de doctores no encontrado.", True)
		Return
	End If
    
	Dim parser As JSONParser
	parser.Initialize(File.ReadString(ruta, nombreArchivo))
    
	Dim root As Map = parser.NextObject
	doctoresList = root.Get("doctores") ' List<Map>
End Sub

Sub LlenarSpinner
	Dim especialidadesSet As Map
	especialidadesSet.Initialize

	For Each doctor As Map In doctoresList
		Dim esp As String = doctor.Get("especialidad")
		especialidadesSet.Put(esp, "")
	Next

	Spiner_especialidad.Clear
	For Each key As String In especialidadesSet.Keys
		Spiner_especialidad.Add(key)
	Next
End Sub

Sub Spiner_especialidad_ItemClick (Position As Int, Value As Object)
	MostrarDoctoresPorEspecialidad(Value)
End Sub

Sub MostrarDoctoresPorEspecialidad(especialidad As String)
	ListaDoctores.Clear

	For Each doctor As Map In doctoresList
		If doctor.Get("especialidad") = especialidad Then
			ListaDoctores.Add(CreateDoctorItem(doctor), "")
		End If
	Next
End Sub

Private Sub Btn_elegirFecha_Click
	ShowDatePickerDialog
End Sub
Sub ShowDatePickerDialog
	Dim jo As JavaObject
	jo.InitializeContext
	jo.RunMethod("showDatePicker", Null)
End Sub
Sub RecibirFecha(fecha As String)
	FechaSeleccionada = fecha
	Log("Fecha: " & FechaSeleccionada)
End Sub
#If Java

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;

public void showDatePicker() {
    Calendar c = Calendar.getInstance();
    DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String fecha = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
            processBA.raiseEventFromUI(this, "recibirfecha", fecha);
        }
    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    dpd.show();
}
#End If



Sub Btn_guardarAtencion_Click
	If DoctorSeleccionado.IsInitialized = False Then
		ToastMessageShow("Selecciona un doctor.", True)
		Return
	End If
	If FechaSeleccionada = "" Then
		ToastMessageShow("Selecciona una fecha.", True)
		Return
	End If
	Dim Rut As String = Main.UsuarioActivo.Rut
	Dim atencion As Map
	atencion.Initialize
	atencion.Put("rut_paciente", Rut)
	atencion.Put("nombre_medico", DoctorSeleccionado.Get("nombre_completo"))
	atencion.Put("especialidad", DoctorSeleccionado.Get("especialidad"))
	atencion.Put("fecha_atencion", FechaSeleccionada)

	Dim ruta As String = File.DirInternal
	Dim archivo As String = "atenciones.json"

	Dim listaAtenciones As List
	If File.Exists(ruta, archivo) Then
		Dim parser As JSONParser
		parser.Initialize(File.ReadString(ruta, archivo))
		listaAtenciones = parser.NextArray
	Else
		listaAtenciones.Initialize
	End If

	listaAtenciones.Add(atencion)

	Dim generador As JSONGenerator
	generador.Initialize2(listaAtenciones)
	File.WriteString(ruta, archivo, generador.ToString)
	ToastMessageShow("Atención guardada correctamente", True)
	Activity.Finish
End Sub
Sub CreateDoctorItem(doctor As Map) As Panel
    Dim p As B4XView = xui.CreatePanel("")
    p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsView.Width, 120dip)
    p.LoadLayout("VistaListaDoctores")

    ' Asigna los datos al diseño
    Lbl_nombre.Text = doctor.Get("nombre_completo")
    Lbl_especialidad.Text = doctor.Get("especialidad")
    
    Dim ruta As String = doctor.Get("foto_perfil")
    If File.Exists(File.DirAssets, ruta) Then
        IMG_Doc.Bitmap = LoadBitmap(File.DirAssets, ruta)
    Else
        IMG_Doc.Bitmap = LoadBitmapSample(File.DirAssets, "default.png", 100dip, 100dip)
    End If

    ' Detectar clic y guardar doctor seleccionado
    p.Tag = doctor
    AddClickEventToPanel(p)

    Return p
End Sub

Sub AddClickEventToPanel(p As B4XView)
    Dim jo As JavaObject = p
    jo.RunMethod("setClickable", Array(True))
    Dim eventName As String = "DoctorPanel"
    Dim pe As Object = jo.CreateEvent("android.view.View.OnClickListener", eventName, False)
    jo.RunMethod("setOnClickListener", Array(pe))
End Sub

Sub DoctorPanel_Event (MethodName As String, Args() As Object) As Object
    Dim v As View = Args(0)
    Dim panelClicked As Panel = v
    DoctorSeleccionado = panelClicked.Tag
    ToastMessageShow("Doctor seleccionado: " & DoctorSeleccionado.Get("nombre_completo"), False)
    Return Null
End Sub