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

	Private Txt_password2 As AutoCompleteEditText
	Private Label3 As Label
	Private Txt_Rut As AutoCompleteEditText
	Private Txt_password As AutoCompleteEditText
	Private Label4 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("CrearUsuario")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub Btn_Regisdtrar_Click
	If ValidarRUT(Txt_Rut.Text) = False Then 
		Label3.Visible = True
		Return
	End If
	If Txt_password2.Text <> Txt_password.text Then
		Label4.Visible = True
		Return
	End If
	RegistrarNuevoUsuario(Txt_Rut.Text,Txt_password.Text)
	
	
End Sub
Sub GuardarUsuarios(ListaUsuarios As List)
	Dim jgen As JSONGenerator
	jgen.Initialize2(ListaUsuarios)
	File.WriteString(File.DirInternal, "usuarios.json", jgen.ToString)
End Sub
Sub RegistrarNuevoUsuario(Rut As String, Contrasena As String)
	Dim usuarios As List 
	usuarios.Initialize
	Rut = Rut.ToUpperCase.Replace(".", "")
	
	usuarios = CargarUsuarios
    
	' Verificar si el RUT ya está registrado
	For Each u As Map In usuarios
		If u.Get("Rut") = Rut Then
			ToastMessageShow("El RUT ya está registrado", True)
			Return
		End If
	Next
    
	' Crear nuevo usuario
	Dim nuevo As Map
	nuevo.Initialize
	nuevo.Put("Rut", Rut)
	nuevo.Put("Contrasena", Contrasena)
    
	usuarios.Add(nuevo)
	GuardarUsuarios(usuarios)
    
	ToastMessageShow("Usuario registrado", False)
	Activity.Finish
End Sub
Sub CargarUsuarios() As List
	Dim Lista As List
	Lista.Initialize
    
	If File.Exists(File.DirInternal, "usuarios.json") Then
		Dim json As String = File.ReadString(File.DirInternal, "usuarios.json")
		Dim jp As JSONParser
		jp.Initialize(json)
		Lista = jp.NextArray
	End If
    
	Return Lista
End Sub
Private Sub Button2_Click
	
End Sub

Private Sub Btn_limpiarPass_Click
	
End Sub

Private Sub Btn_limpiarRut_Click
	
End Sub
Sub ValidarRUT(RutTexto As String) As Boolean
	Dim rut As String = RutTexto.Trim.ToUpperCase
    
	' Rechazar caracteres inválidos: solo se aceptan dígitos, puntos, guiones y "K"
	If Regex.IsMatch("[^0-9Kk\.\-]", rut) Then Return False

	' Limpiar puntos y guion si los hay
	rut = rut.Replace(".", "").Replace("-", "")
    
	' Verificar que tenga al menos 2 caracteres (número + dígito verificador)
	If rut.Length < 2 Then Return False
    
	' Separar cuerpo del rut y dígito verificador
	Dim cuerpo As String = rut.SubString2(0, rut.Length - 1)
	Dim dvIngresado As String = rut.SubString(rut.Length - 1)
    
	' Verificar que cuerpo solo tenga números
	If Regex.IsMatch("[^0-9]", cuerpo) Then Return False
    
	' Calcular dígito verificador esperado
	Dim suma As Int = 0
	Dim multiplicador As Int = 2
    
	For i = cuerpo.Length - 1 To 0 Step -1
		Dim digito As Int = Bit.ParseInt("" & cuerpo.CharAt(i), 10)
		suma = suma + digito * multiplicador
		multiplicador = multiplicador + 1
		If multiplicador > 7 Then multiplicador = 2
	Next
    
	Dim resto As Int = suma Mod 11
	Dim dvCalculado As String
	Select Case 11 - resto
		Case 11
			dvCalculado = "0"
		Case 10
			dvCalculado = "K"
		Case Else
			dvCalculado = (11 - resto)
	End Select
    
	' Comparar con el dígito ingresado
	Return dvCalculado = dvIngresado
End Sub
