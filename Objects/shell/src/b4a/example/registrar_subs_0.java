package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrar_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"CrearUsuario\")";
Debug.ShouldStop(16777216);
registrar.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("CrearUsuario")),registrar.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","activity_resume");}
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_limpiarpass_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_limpiarPass_Click (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,100);
if (RapidSub.canDelegate("btn_limpiarpass_click")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","btn_limpiarpass_click");}
 BA.debugLineNum = 100;BA.debugLine="Private Sub Btn_limpiarPass_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_limpiarrut_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_limpiarRut_Click (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,104);
if (RapidSub.canDelegate("btn_limpiarrut_click")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","btn_limpiarrut_click");}
 BA.debugLineNum = 104;BA.debugLine="Private Sub Btn_limpiarRut_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_regisdtrar_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Regisdtrar_Click (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,38);
if (RapidSub.canDelegate("btn_regisdtrar_click")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","btn_regisdtrar_click");}
 BA.debugLineNum = 38;BA.debugLine="Private Sub Btn_Regisdtrar_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="If ValidarRUT(Txt_Rut.Text) = False Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_validarrut(registrar.mostCurrent._txt_rut.runMethod(true,"getText")),registrar.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 40;BA.debugLine="Label3.Visible = True";
Debug.ShouldStop(128);
registrar.mostCurrent._label3.runMethod(true,"setVisible",registrar.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 41;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 43;BA.debugLine="If Txt_password2.Text <> Txt_password.text Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("!",registrar.mostCurrent._txt_password2.runMethod(true,"getText"),registrar.mostCurrent._txt_password.runMethod(true,"getText"))) { 
 BA.debugLineNum = 44;BA.debugLine="Label4.Visible = True";
Debug.ShouldStop(2048);
registrar.mostCurrent._label4.runMethod(true,"setVisible",registrar.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 45;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 47;BA.debugLine="RegistrarNuevoUsuario(Txt_Rut.Text,Txt_password.T";
Debug.ShouldStop(16384);
_registrarnuevousuario(registrar.mostCurrent._txt_rut.runMethod(true,"getText"),registrar.mostCurrent._txt_password.runMethod(true,"getText"));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,96);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","button2_click");}
 BA.debugLineNum = 96;BA.debugLine="Private Sub Button2_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cargarusuarios() throws Exception{
try {
		Debug.PushSubsStack("CargarUsuarios (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,83);
if (RapidSub.canDelegate("cargarusuarios")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","cargarusuarios");}
RemoteObject _lista = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _json = RemoteObject.createImmutable("");
RemoteObject _jp = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
 BA.debugLineNum = 83;BA.debugLine="Sub CargarUsuarios() As List";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="Dim Lista As List";
Debug.ShouldStop(524288);
_lista = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Lista", _lista);
 BA.debugLineNum = 85;BA.debugLine="Lista.Initialize";
Debug.ShouldStop(1048576);
_lista.runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="If File.Exists(File.DirInternal, \"usuarios.json\")";
Debug.ShouldStop(4194304);
if (registrar.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(registrar.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("usuarios.json"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 88;BA.debugLine="Dim json As String = File.ReadString(File.DirInt";
Debug.ShouldStop(8388608);
_json = registrar.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(registrar.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("usuarios.json")));Debug.locals.put("json", _json);Debug.locals.put("json", _json);
 BA.debugLineNum = 89;BA.debugLine="Dim jp As JSONParser";
Debug.ShouldStop(16777216);
_jp = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jp", _jp);
 BA.debugLineNum = 90;BA.debugLine="jp.Initialize(json)";
Debug.ShouldStop(33554432);
_jp.runVoidMethod ("Initialize",(Object)(_json));
 BA.debugLineNum = 91;BA.debugLine="Lista = jp.NextArray";
Debug.ShouldStop(67108864);
_lista = _jp.runMethod(false,"NextArray");Debug.locals.put("Lista", _lista);
 };
 BA.debugLineNum = 94;BA.debugLine="Return Lista";
Debug.ShouldStop(536870912);
if (true) return _lista;
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private Txt_password2 As AutoCompleteEditText";
registrar.mostCurrent._txt_password2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Label3 As Label";
registrar.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Txt_Rut As AutoCompleteEditText";
registrar.mostCurrent._txt_rut = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private Txt_password As AutoCompleteEditText";
registrar.mostCurrent._txt_password = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Label4 As Label";
registrar.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _guardarusuarios(RemoteObject _listausuarios) throws Exception{
try {
		Debug.PushSubsStack("GuardarUsuarios (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,51);
if (RapidSub.canDelegate("guardarusuarios")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","guardarusuarios", _listausuarios);}
RemoteObject _jgen = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
Debug.locals.put("ListaUsuarios", _listausuarios);
 BA.debugLineNum = 51;BA.debugLine="Sub GuardarUsuarios(ListaUsuarios As List)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="Dim jgen As JSONGenerator";
Debug.ShouldStop(524288);
_jgen = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jgen", _jgen);
 BA.debugLineNum = 53;BA.debugLine="jgen.Initialize2(ListaUsuarios)";
Debug.ShouldStop(1048576);
_jgen.runVoidMethod ("Initialize2",(Object)(_listausuarios));
 BA.debugLineNum = 54;BA.debugLine="File.WriteString(File.DirInternal, \"usuarios.json";
Debug.ShouldStop(2097152);
registrar.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(registrar.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("usuarios.json")),(Object)(_jgen.runMethod(true,"ToString")));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _registrarnuevousuario(RemoteObject _rut,RemoteObject _contrasena) throws Exception{
try {
		Debug.PushSubsStack("RegistrarNuevoUsuario (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,56);
if (RapidSub.canDelegate("registrarnuevousuario")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","registrarnuevousuario", _rut, _contrasena);}
RemoteObject _usuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nuevo = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("Rut", _rut);
Debug.locals.put("Contrasena", _contrasena);
 BA.debugLineNum = 56;BA.debugLine="Sub RegistrarNuevoUsuario(Rut As String, Contrasen";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="Dim usuarios As List";
Debug.ShouldStop(16777216);
_usuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 58;BA.debugLine="usuarios.Initialize";
Debug.ShouldStop(33554432);
_usuarios.runVoidMethod ("Initialize");
 BA.debugLineNum = 59;BA.debugLine="Rut = Rut.ToUpperCase.Replace(\".\", \"\")";
Debug.ShouldStop(67108864);
_rut = _rut.runMethod(true,"toUpperCase").runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("Rut", _rut);
 BA.debugLineNum = 61;BA.debugLine="usuarios = CargarUsuarios";
Debug.ShouldStop(268435456);
_usuarios = _cargarusuarios();Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 64;BA.debugLine="For Each u As Map In usuarios";
Debug.ShouldStop(-2147483648);
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group5 = _usuarios;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_u = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group5.runMethod(false,"Get",index5));Debug.locals.put("u", _u);
Debug.locals.put("u", _u);
 BA.debugLineNum = 65;BA.debugLine="If u.Get(\"Rut\") = Rut Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_u.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Rut")))),(_rut))) { 
 BA.debugLineNum = 66;BA.debugLine="ToastMessageShow(\"El RUT ya está registrado\", T";
Debug.ShouldStop(2);
registrar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("El RUT ya está registrado")),(Object)(registrar.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 67;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("u", _u);
;
 BA.debugLineNum = 72;BA.debugLine="Dim nuevo As Map";
Debug.ShouldStop(128);
_nuevo = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("nuevo", _nuevo);
 BA.debugLineNum = 73;BA.debugLine="nuevo.Initialize";
Debug.ShouldStop(256);
_nuevo.runVoidMethod ("Initialize");
 BA.debugLineNum = 74;BA.debugLine="nuevo.Put(\"Rut\", Rut)";
Debug.ShouldStop(512);
_nuevo.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Rut"))),(Object)((_rut)));
 BA.debugLineNum = 75;BA.debugLine="nuevo.Put(\"Contrasena\", Contrasena)";
Debug.ShouldStop(1024);
_nuevo.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Contrasena"))),(Object)((_contrasena)));
 BA.debugLineNum = 77;BA.debugLine="usuarios.Add(nuevo)";
Debug.ShouldStop(4096);
_usuarios.runVoidMethod ("Add",(Object)((_nuevo.getObject())));
 BA.debugLineNum = 78;BA.debugLine="GuardarUsuarios(usuarios)";
Debug.ShouldStop(8192);
_guardarusuarios(_usuarios);
 BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"Usuario registrado\", False)";
Debug.ShouldStop(32768);
registrar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Usuario registrado")),(Object)(registrar.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 81;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
registrar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _validarrut(RemoteObject _ruttexto) throws Exception{
try {
		Debug.PushSubsStack("ValidarRUT (registrar) ","registrar",2,registrar.mostCurrent.activityBA,registrar.mostCurrent,107);
if (RapidSub.canDelegate("validarrut")) { return b4a.example.registrar.remoteMe.runUserSub(false, "registrar","validarrut", _ruttexto);}
RemoteObject _rut = RemoteObject.createImmutable("");
RemoteObject _cuerpo = RemoteObject.createImmutable("");
RemoteObject _dvingresado = RemoteObject.createImmutable("");
RemoteObject _suma = RemoteObject.createImmutable(0);
RemoteObject _multiplicador = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _digito = RemoteObject.createImmutable(0);
RemoteObject _resto = RemoteObject.createImmutable(0);
RemoteObject _dvcalculado = RemoteObject.createImmutable("");
Debug.locals.put("RutTexto", _ruttexto);
 BA.debugLineNum = 107;BA.debugLine="Sub ValidarRUT(RutTexto As String) As Boolean";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="Dim rut As String = RutTexto.Trim.ToUpperCase";
Debug.ShouldStop(2048);
_rut = _ruttexto.runMethod(true,"trim").runMethod(true,"toUpperCase");Debug.locals.put("rut", _rut);Debug.locals.put("rut", _rut);
 BA.debugLineNum = 111;BA.debugLine="If Regex.IsMatch(\"[^0-9Kk\\.\\-]\", rut) Then Return";
Debug.ShouldStop(16384);
if (registrar.mostCurrent.__c.getField(false,"Regex").runMethod(true,"IsMatch",(Object)(BA.ObjectToString("[^0-9Kk\\.\\-]")),(Object)(_rut)).<Boolean>get().booleanValue()) { 
if (true) return registrar.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 114;BA.debugLine="rut = rut.Replace(\".\", \"\").Replace(\"-\", \"\")";
Debug.ShouldStop(131072);
_rut = _rut.runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable(""))).runMethod(true,"replace",(Object)(BA.ObjectToString("-")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("rut", _rut);
 BA.debugLineNum = 117;BA.debugLine="If rut.Length < 2 Then Return False";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("<",_rut.runMethod(true,"length"),BA.numberCast(double.class, 2))) { 
if (true) return registrar.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 120;BA.debugLine="Dim cuerpo As String = rut.SubString2(0, rut.Leng";
Debug.ShouldStop(8388608);
_cuerpo = _rut.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_rut.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("cuerpo", _cuerpo);Debug.locals.put("cuerpo", _cuerpo);
 BA.debugLineNum = 121;BA.debugLine="Dim dvIngresado As String = rut.SubString(rut.Len";
Debug.ShouldStop(16777216);
_dvingresado = _rut.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_rut.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("dvIngresado", _dvingresado);Debug.locals.put("dvIngresado", _dvingresado);
 BA.debugLineNum = 124;BA.debugLine="If Regex.IsMatch(\"[^0-9]\", cuerpo) Then Return Fa";
Debug.ShouldStop(134217728);
if (registrar.mostCurrent.__c.getField(false,"Regex").runMethod(true,"IsMatch",(Object)(BA.ObjectToString("[^0-9]")),(Object)(_cuerpo)).<Boolean>get().booleanValue()) { 
if (true) return registrar.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 127;BA.debugLine="Dim suma As Int = 0";
Debug.ShouldStop(1073741824);
_suma = BA.numberCast(int.class, 0);Debug.locals.put("suma", _suma);Debug.locals.put("suma", _suma);
 BA.debugLineNum = 128;BA.debugLine="Dim multiplicador As Int = 2";
Debug.ShouldStop(-2147483648);
_multiplicador = BA.numberCast(int.class, 2);Debug.locals.put("multiplicador", _multiplicador);Debug.locals.put("multiplicador", _multiplicador);
 BA.debugLineNum = 130;BA.debugLine="For i = cuerpo.Length - 1 To 0 Step -1";
Debug.ShouldStop(2);
{
final int step10 = -1;
final int limit10 = 0;
_i = RemoteObject.solve(new RemoteObject[] {_cuerpo.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 131;BA.debugLine="Dim digito As Int = Bit.ParseInt(\"\" & cuerpo.Cha";
Debug.ShouldStop(4);
_digito = registrar.mostCurrent.__c.getField(false,"Bit").runMethod(true,"ParseInt",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),_cuerpo.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _i))))),(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("digito", _digito);Debug.locals.put("digito", _digito);
 BA.debugLineNum = 132;BA.debugLine="suma = suma + digito * multiplicador";
Debug.ShouldStop(8);
_suma = RemoteObject.solve(new RemoteObject[] {_suma,_digito,_multiplicador}, "+*",1, 1);Debug.locals.put("suma", _suma);
 BA.debugLineNum = 133;BA.debugLine="multiplicador = multiplicador + 1";
Debug.ShouldStop(16);
_multiplicador = RemoteObject.solve(new RemoteObject[] {_multiplicador,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("multiplicador", _multiplicador);
 BA.debugLineNum = 134;BA.debugLine="If multiplicador > 7 Then multiplicador = 2";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",_multiplicador,BA.numberCast(double.class, 7))) { 
_multiplicador = BA.numberCast(int.class, 2);Debug.locals.put("multiplicador", _multiplicador);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 137;BA.debugLine="Dim resto As Int = suma Mod 11";
Debug.ShouldStop(256);
_resto = RemoteObject.solve(new RemoteObject[] {_suma,RemoteObject.createImmutable(11)}, "%",0, 1);Debug.locals.put("resto", _resto);Debug.locals.put("resto", _resto);
 BA.debugLineNum = 138;BA.debugLine="Dim dvCalculado As String";
Debug.ShouldStop(512);
_dvcalculado = RemoteObject.createImmutable("");Debug.locals.put("dvCalculado", _dvcalculado);
 BA.debugLineNum = 139;BA.debugLine="Select Case 11 - resto";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(11),_resto}, "-",1, 1),BA.numberCast(int.class, 11),BA.numberCast(int.class, 10))) {
case 0: {
 BA.debugLineNum = 141;BA.debugLine="dvCalculado = \"0\"";
Debug.ShouldStop(4096);
_dvcalculado = BA.ObjectToString("0");Debug.locals.put("dvCalculado", _dvcalculado);
 break; }
case 1: {
 BA.debugLineNum = 143;BA.debugLine="dvCalculado = \"K\"";
Debug.ShouldStop(16384);
_dvcalculado = BA.ObjectToString("K");Debug.locals.put("dvCalculado", _dvcalculado);
 break; }
default: {
 BA.debugLineNum = 145;BA.debugLine="dvCalculado = (11 - resto)";
Debug.ShouldStop(65536);
_dvcalculado = BA.NumberToString((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(11),_resto}, "-",1, 1)));Debug.locals.put("dvCalculado", _dvcalculado);
 break; }
}
;
 BA.debugLineNum = 149;BA.debugLine="Return dvCalculado = dvIngresado";
Debug.ShouldStop(1048576);
if (true) return BA.ObjectToBoolean(RemoteObject.solveBoolean("=",_dvcalculado,_dvingresado));
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}