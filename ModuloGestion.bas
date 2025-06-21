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
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private xui As XUI
	Private ListaCitas As CustomListView
	Private Btn_Cancelar As Button
	Private Btn_Editar As Button
	Private Lbl_Fecha As Label
	Private Lbl_Medico As Label
	Private ListaDoctores As CustomListView
	Private Btn_Modificar As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("VistaGesionar")
	MostrarAtenciones
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Btn_Modificar_Click
	Dim btn As Button = Sender
	Dim indice As Int = btn.Tag
	MostrarDatePickerParaModificar(indice)
End Sub

Sub MostrarDatePickerParaModificar(indice As Int)
	Dim jo As JavaObject
	jo.InitializeContext
	jo.RunMethod("mostrarDatePickerModificar", Array(indice))
End Sub
Sub Btn_Cancelar_Click
	Dim btn As Button = Sender
	Dim indice As Int = btn.Tag
	Dim res As Int = Msgbox2("¿Deseas cancelar esta cita?", "Confirmar", "Sí", "", "No", Null)
	If res = DialogResponse.POSITIVE Then
		EliminarAtencion(indice)
	End If
End Sub

Sub EliminarAtencion(indice As Int)
	Dim ruta As String = File.DirInternal
	Dim archivo As String = "atenciones.json"
	Dim parser As JSONParser
	parser.Initialize(File.ReadString(ruta, archivo))
	Dim lista As List = parser.NextArray

	lista.RemoveAt(indice)

	Dim generador As JSONGenerator
	generador.Initialize2(lista)
	File.WriteString(ruta, archivo, generador.ToString)

	ToastMessageShow("Cita cancelada", True)
	MostrarAtenciones
End Sub
#If Java
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;

public void mostrarDatePickerModificar(final int indice) {
    Calendar c = Calendar.getInstance();
    DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String fecha = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
            Object[] args = new Object[]{fecha, indice};
            processBA.raiseEventFromUI(this, "recibirfechamodificada", args);
        }
    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    dpd.show();
}
#End If

Sub RecibirFechaModificada(fecha As String, indice As Int)
	' Modificar la fecha de esa atención y guardar
	Dim ruta As String = File.DirInternal
	Dim archivo As String = "atenciones.json"
	Dim parser As JSONParser
	parser.Initialize(File.ReadString(ruta, archivo))
	Dim lista As List = parser.NextArray

	Dim atencion As Map = lista.Get(indice)
	atencion.Put("fecha_atencion", fecha)

	Dim generador As JSONGenerator
	generador.Initialize2(lista)
	File.WriteString(ruta, archivo, generador.ToString)

	ToastMessageShow("Fecha modificada", True)
	MostrarAtenciones
End Sub
Sub MostrarAtenciones
	ListaDoctores.Clear
	Dim ruta As String = File.DirInternal
	Dim archivo As String = "atenciones.json"

	If File.Exists(ruta, archivo) = False Then Return

	Dim parser As JSONParser
	parser.Initialize(File.ReadString(ruta, archivo))
	Dim lista As List = parser.NextArray

	Dim rutActual As String = Main.UsuarioActivo.Rut
	Dim indiceVisual As Int = 0

	For i = 0 To lista.Size - 1
		Dim atencion As Map = lista.Get(i)
		If atencion.Get("rut_paciente") = rutActual Then
			Dim p As B4XView = xui.CreatePanel("")
			p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsView.Width, 150dip)
			p.LoadLayout("VistaMod")

			Lbl_Medico.Text = atencion.Get("nombre_medico")
			Lbl_Fecha.Text = atencion.Get("fecha_atencion")

			' Guardamos el índice real (i) en el tag para usarlo luego al modificar o eliminar
			Btn_Modificar.Tag = i
			Btn_Cancelar.Tag = i

			ListaDoctores.Add(p, "")
			indiceVisual = indiceVisual + 1
		End If
	Next
End Sub
Private Sub ListaCitas_ItemClick (Index As Int, Value As Object)
	
End Sub