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
	Private listaExamenes As List
	Private ImageViewer As ImageView
	Private CLV_Examenes As CustomListView
	Private Panel1 As Panel
	Private xui As XUI
	Private MainPanel As Panel
	Private PanelEXA As Panel
End Sub
Sub CrearArchivoExamenesSiNoExiste
	Dim ruta As String = File.DirInternal
	Dim archivo As String = "examenes.json"
    
	If File.Exists(ruta, archivo) Then Return ' Ya existe

	Dim examenes As List
	examenes.Initialize

	For i = 1 To 3
		Dim ex As Map
		ex.Initialize
		ex.Put("NombreDelProcedimiento", "Radiografía Tórax " & i)
		ex.Put("RutaImagen", "imagen" & i & ".jpg")
		ex.Put("FechaRealizado", "15/06/2025")
		ex.Put("Rut", Main.UsuarioActivo.Rut)
		examenes.Add(ex)
	Next

	Dim gen As JSONGenerator
	gen.Initialize2(examenes)
	File.WriteString(ruta, archivo, gen.ToString)
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("VistaExamenes")
	CrearArchivoExamenesSiNoExiste
	CargarExamenes
End Sub

Sub CargarExamenes
	listaExamenes.Initialize
	Dim ruta As String = File.DirInternal
	Dim archivo As String = "examenes.json"

	If File.Exists(ruta, archivo) = False Then
		ToastMessageShow("No se encontró el archivo de exámenes.", True)
		Return
	End If

	Dim parser As JSONParser
	parser.Initialize(File.ReadString(ruta, archivo))
	listaExamenes = parser.NextArray

	CLV_Examenes.Clear

	For Each examen As Map In listaExamenes
		If examen.Get("Rut") = Main.UsuarioActivo.Rut Then
			CLV_Examenes.Add(CreateItemExamen(examen), "")
		End If
	Next
End Sub

Sub CreateItemExamen(examen As Map) As Panel
	Dim p As B4XView = xui.CreatePanel("")
	p.SetLayoutAnimated(0, 0, 0, CLV_Examenes.AsView.Width, 120dip)
	p.LoadLayout("VistaExamen") ' este es tu layout con Panel1, Lbl_Proc, etc.
	Dim PAn As Panel = p.GetView(0)
	Dim LblProc As Label = PAn.GetView(0) ' o usa Panel1.GetView(...) según jerarquía
	Dim LblFecha As Label = PAn.GetView(1)
	Dim BtnVer As Button = PAn.GetView(2)

	LblProc.Text = examen.Get("NombreDelProcedimiento")
	LblFecha.Text = examen.Get("FechaRealizado")

	BtnVer.Tag = examen.Get("RutaImagen")
	
	Return p
End Sub
Sub BtnVer_Click
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub Btn_cerrar_Click
	PanelEXA.Visible  = False
	MainPanel.Visible = True
End Sub

Private Sub Btn_Ver_Click
	Dim btn As Button = Sender
	Dim ruta As String = btn.Tag

	If File.Exists(File.DirAssets, ruta) Then
		PanelEXA.Visible = True
		
		MainPanel.Visible = False
		
		ImageViewer.Bitmap = LoadBitmap(File.DirAssets, ruta)
	Else
		ToastMessageShow("Imagen no encontrada: " & ruta, True)
	End If
End Sub