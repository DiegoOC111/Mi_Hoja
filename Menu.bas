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
	Private FechaSeleccionada As String
	Dim xui As XUI
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Menuvista")
	VerificarProximaAtencion
End Sub

Sub Activity_Resume

End Sub

Sub MostrarMensajeShock(titulo As String, mensaje As String)
	xui.MsgboxAsync(mensaje, titulo)
End Sub
Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub Btn_Fecha_Click
	StartActivity(Modulo_Seleccion)
End Sub

Private Sub Btn_Gestionar_Click
	StartActivity("ModuloGestion")
End Sub
Sub VerificarProximaAtencion
	Dim ruta As String = File.DirInternal
	Dim archivo As String = "atenciones.json"
	If File.Exists(ruta, archivo) = False Then Return

	Dim parser As JSONParser
	parser.Initialize(File.ReadString(ruta, archivo))
	Dim lista As List = parser.NextArray
	DateTime.DateFormat = "dd/MM/yyyy"
	Dim rutActual As String = Main.UsuarioActivo.Rut

	Dim hoy As Long = DateTime.Now
	Dim mañana As Long = hoy + DateTime.TicksPerDay

	For Each atencion As Map In lista
		If atencion.Get("rut_paciente") = rutActual Then
			Dim fechaTexto As String = atencion.Get("fecha_atencion") ' Ej: "20/06/2025"
			Try
				Dim fechaTicks As Long = DateTime.DateParse(fechaTexto)
				If DateUtils.IsSameDay(fechaTicks, hoy) Then
					MostrarMensajeShock("¡Tienes una atención médica hoy!", "Tienes una hora agendada para el dia: "&fechaTexto )
					Return
				Else If DateUtils.IsSameDay(fechaTicks, mañana) Then
					MostrarMensajeShock("¡Tienes una atención médica mañana!", "Tienes una hora agendada para el dia: "&fechaTexto)
					Return
				End If
			Catch
				Log("Error al interpretar fecha: " & fechaTexto)
			End Try
		End If
	Next
End Sub


Private Sub Btn_calendario_Click
	StartActivity(Calendario)
End Sub