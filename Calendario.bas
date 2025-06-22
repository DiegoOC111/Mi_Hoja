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
	Private listaAtenciones As List
	Private fechasConAtencion As List
	Private CLV_Calendario As CustomListView
	Private xui As XUI
	Private Lbl_dia As Label
	Private PanelDia As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("VistaCalendario")
	listaAtenciones.Initialize
	fechasConAtencion.Initialize
	DateTime.DateFormat = "dd/MM/yyyy"

	CargarFechasPaciente(Main.UsuarioActivo.Rut)
	GenerarCalendarioMes(DateTime.GetYear(DateTime.Now), DateTime.GetMonth(DateTime.Now))
End Sub

Sub Activity_Resume

End Sub
Sub GenerarCalendarioMes(año As Int, mes As Int)
	CLV_Calendario.Clear
	CLV_Calendario.Add(CrearFilaDiasSemana, "")

	Dim diasMes As Int = DateUtils.NumberOfDaysInMonth(mes, año)
	Dim primerDiaSemana As Int = DateTime.GetDayOfWeek(DateUtils.SetDate(año, mes, 1)) ' 1=Domingo

	' Ajustar a que lunes sea 0
	Dim offset As Int = primerDiaSemana - 2
	If offset < 0 Then offset = 6

	Dim diasEnFila As Int = 0
	Dim fila As Panel = CrearFilaCalendario

	' Huecos al inicio
	For i = 0 To offset - 1
		fila.GetView(i).Visible = False
		diasEnFila = diasEnFila + 1
	Next

	' Agregar días
	For dia = 1 To diasMes
		If diasEnFila = 7 Then
			CLV_Calendario.Add(fila, "")
			fila = CrearFilaCalendario
			diasEnFila = 0
		End If

		Dim p As B4XView = fila.GetView(diasEnFila)
		AsignarDiaAPanel(p, dia, mes, año)
		
		diasEnFila = diasEnFila + 1
	Next

	CLV_Calendario.Add(fila, "")
End Sub

Sub CrearFilaCalendario As Panel
	Dim fila As Panel
	fila.Initialize("")
	fila.SetLayout(0, 0, 100%x, 50dip)

	For i = 0 To 6
		Dim p As B4XView = xui.CreatePanel("")
		p.LoadLayout("item_dia")
		fila.AddView(p, i * (100%x / 7), 0, 100%x / 7, 50dip)
	Next
	Return fila
End Sub

Sub CargarFechasPaciente(rut As String)
	Dim parser As JSONParser
	Dim archivo As String = "atenciones.json"
	If File.Exists(File.DirInternal, archivo) = False Then Return

	parser.Initialize(File.ReadString(File.DirInternal, archivo))
	listaAtenciones = parser.NextArray
	DateTime.DateFormat = "dd/MM/yyyy"

	For Each atencion As Map In listaAtenciones
		If atencion.Get("rut_paciente") = rut Then
			fechasConAtencion.Add(atencion.Get("fecha_atencion"))
		End If
	Next
End Sub

Sub AsignarDiaAPanel(p As B4XView, dia As Int, mes As Int, año As Int)
    Dim fechaTexto As String = NumberFormat2(dia, 2, 0, 0, False) & "/" & NumberFormat2(mes, 2, 0, 0, False) & "/" & año

   Dim contenedor As Panel = p.GetView(0)
	Dim lbl As Label = contenedor.GetView(0)' Ajusta si tu jerarquía es distinta
    lbl.Text = dia

    If fechasConAtencion.IndexOf(fechaTexto) > -1 Then
        lbl.TextColor = Colors.Red
    Else
        lbl.TextColor = Colors.Black
	End If
	Dim MESAUX As String
	If(mes < 10) Then
		MESAUX = $"0${mes}"$
	Else
		MESAUX = mes
	End If
	contenedor.Tag= $"${dia}/${MESAUX}/${año}"$
    
End Sub

Sub PanelDia_Click
	Dim btn As Panel = Sender
	
	Dim fecha As String = btn.Tag
	

	For Each atencion As Map In listaAtenciones
		If atencion.Get("rut_paciente") = Main.UsuarioActivo.Rut And atencion.Get("fecha_atencion") = fecha Then
			Dim msg As String = "Atención con: " & atencion.Get("nombre_medico") & CRLF & "Especialidad: " & atencion.Get("especialidad")& CRLF&"Fecha: "& fecha
			Msgbox(msg, "Atención médica")
			Return
		End If
	Next

	ToastMessageShow("No hay atención este día", False)
End Sub

Sub CrearFilaDiasSemana As Panel
	Dim fila As Panel
	fila.Initialize("")
	fila.SetLayout(0, 0, 100%x, 40dip)

	Dim nombresDias() As String = Array As String("L", "M", "M", "J", "V", "S", "D")

	For i = 0 To 6
		Dim lbl As Label
		lbl.Initialize("")
		lbl.Text = nombresDias(i)
		lbl.Gravity = Gravity.CENTER
		lbl.TextSize = 16
		fila.AddView(lbl, i * (100%x / 7), 0, 100%x / 7, 40dip)
	Next

	Return fila
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
