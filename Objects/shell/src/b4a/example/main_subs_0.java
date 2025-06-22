package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,45);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 47;BA.debugLine="CrearArchivoDoctores";
Debug.ShouldStop(16384);
_creararchivodoctores();
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,54);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 54;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_crear_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Crear_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("btn_crear_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btn_crear_click");}
 BA.debugLineNum = 62;BA.debugLine="Private Sub Btn_Crear_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="StartActivity(Registrar)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registrar.getObject())));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_iniciar_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_iniciar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("btn_iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btn_iniciar_click");}
RemoteObject _rut = RemoteObject.createImmutable("");
RemoteObject _clave = RemoteObject.createImmutable("");
RemoteObject _usuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 66;BA.debugLine="Private Sub Btn_iniciar_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Dim rut As String = Txt_Rut.Text";
Debug.ShouldStop(4);
_rut = main.mostCurrent._txt_rut.runMethod(true,"getText");Debug.locals.put("rut", _rut);Debug.locals.put("rut", _rut);
 BA.debugLineNum = 68;BA.debugLine="Dim clave As String = Txt_password.Text";
Debug.ShouldStop(8);
_clave = main.mostCurrent._txt_password.runMethod(true,"getText");Debug.locals.put("clave", _clave);Debug.locals.put("clave", _clave);
 BA.debugLineNum = 71;BA.debugLine="If rut = \"\" Or clave = \"\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_rut,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_clave,BA.ObjectToString(""))) { 
 BA.debugLineNum = 72;BA.debugLine="xui.MsgboxAsync(\"Debes ingresar RUT y contraseña";
Debug.ShouldStop(128);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Debes ingresar RUT y contraseña")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 73;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 76;BA.debugLine="rut = rut.ToUpperCase.Replace(\".\", \"\")";
Debug.ShouldStop(2048);
_rut = _rut.runMethod(true,"toUpperCase").runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("rut", _rut);
 BA.debugLineNum = 79;BA.debugLine="Dim usuarios As List = CargarUsuarios";
Debug.ShouldStop(16384);
_usuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_usuarios = _cargarusuarios();Debug.locals.put("usuarios", _usuarios);Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 82;BA.debugLine="For Each u As Map In usuarios";
Debug.ShouldStop(131072);
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group9 = _usuarios;
final int groupLen9 = group9.runMethod(true,"getSize").<Integer>get()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_u = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group9.runMethod(false,"Get",index9));Debug.locals.put("u", _u);
Debug.locals.put("u", _u);
 BA.debugLineNum = 83;BA.debugLine="If u.Get(\"Rut\") = rut And u.Get(\"Contrasena\") =";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_u.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Rut")))),(_rut)) && RemoteObject.solveBoolean("=",_u.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Contrasena")))),(_clave))) { 
 BA.debugLineNum = 84;BA.debugLine="UsuarioActivo.Contrasena = clave";
Debug.ShouldStop(524288);
main._usuarioactivo.setField ("Contrasena" /*RemoteObject*/ ,_clave);
 BA.debugLineNum = 85;BA.debugLine="UsuarioActivo.Rut = rut";
Debug.ShouldStop(1048576);
main._usuarioactivo.setField ("Rut" /*RemoteObject*/ ,_rut);
 BA.debugLineNum = 86;BA.debugLine="xui.MsgboxAsync(\"Inicio de sesión exitoso\", \"Bi";
Debug.ShouldStop(2097152);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Inicio de sesión exitoso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Bienvenido"))));
 BA.debugLineNum = 88;BA.debugLine="StartActivity(Menu)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._menu.getObject())));
 BA.debugLineNum = 89;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("u", _u);
;
 BA.debugLineNum = 94;BA.debugLine="xui.MsgboxAsync(\"RUT o contraseña incorrectos\", \"";
Debug.ShouldStop(536870912);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("RUT o contraseña incorrectos")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 58;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
Debug.ShouldStop(67108864);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Hello world!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("B4X"))));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("CargarUsuarios (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("cargarusuarios")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cargarusuarios");}
RemoteObject _lista = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _json = RemoteObject.createImmutable("");
RemoteObject _jp = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
 BA.debugLineNum = 32;BA.debugLine="Sub CargarUsuarios() As List";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim Lista As List";
Debug.ShouldStop(1);
_lista = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Lista", _lista);
 BA.debugLineNum = 34;BA.debugLine="Lista.Initialize";
Debug.ShouldStop(2);
_lista.runVoidMethod ("Initialize");
 BA.debugLineNum = 36;BA.debugLine="If File.Exists(File.DirInternal, \"usuarios.json\")";
Debug.ShouldStop(8);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("usuarios.json"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 37;BA.debugLine="Dim json As String = File.ReadString(File.DirInt";
Debug.ShouldStop(16);
_json = main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("usuarios.json")));Debug.locals.put("json", _json);Debug.locals.put("json", _json);
 BA.debugLineNum = 38;BA.debugLine="Dim jp As JSONParser";
Debug.ShouldStop(32);
_jp = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jp", _jp);
 BA.debugLineNum = 39;BA.debugLine="jp.Initialize(json)";
Debug.ShouldStop(64);
_jp.runVoidMethod ("Initialize",(Object)(_json));
 BA.debugLineNum = 40;BA.debugLine="Lista = jp.NextArray";
Debug.ShouldStop(128);
_lista = _jp.runMethod(false,"NextArray");Debug.locals.put("Lista", _lista);
 };
 BA.debugLineNum = 43;BA.debugLine="Return Lista";
Debug.ShouldStop(1024);
if (true) return _lista;
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _creararchivodoctores() throws Exception{
try {
		Debug.PushSubsStack("CrearArchivoDoctores (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("creararchivodoctores")) { return b4a.example.main.remoteMe.runUserSub(false, "main","creararchivodoctores");}
RemoteObject _nombrearchivo = RemoteObject.createImmutable("");
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _contenido = RemoteObject.createImmutable("");
 BA.debugLineNum = 96;BA.debugLine="Sub CrearArchivoDoctores";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim nombreArchivo As String = \"doctores.json\"";
Debug.ShouldStop(1);
_nombrearchivo = BA.ObjectToString("doctores.json");Debug.locals.put("nombreArchivo", _nombrearchivo);Debug.locals.put("nombreArchivo", _nombrearchivo);
 BA.debugLineNum = 98;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(2);
_ruta = main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 107;BA.debugLine="Dim contenido As String = $\"{   \"doctores\": [";
Debug.ShouldStop(1024);
_contenido = (RemoteObject.concat(RemoteObject.createImmutable("{\n"),RemoteObject.createImmutable("  \"doctores\": [\n"),RemoteObject.createImmutable("    {\n"),RemoteObject.createImmutable("      \"nombre_completo\": \"Dra. Valentina Ríos Martínez\",\n"),RemoteObject.createImmutable("      \"especialidad\": \"Cardiología Pediátrica\",\n"),RemoteObject.createImmutable("      \"foto_perfil\": \"valentina_rios.png\"\n"),RemoteObject.createImmutable("    },\n"),RemoteObject.createImmutable("    {\n"),RemoteObject.createImmutable("      \"nombre_completo\": \"Dr. Sebastián Torres Guzmán\",\n"),RemoteObject.createImmutable("      \"especialidad\": \"Pediatría General\",\n"),RemoteObject.createImmutable("      \"foto_perfil\": \"sebastian_torres.png\"\n"),RemoteObject.createImmutable("    },\n"),RemoteObject.createImmutable("    {\n"),RemoteObject.createImmutable("      \"nombre_completo\": \"Dra. Camila Herrera Soto\",\n"),RemoteObject.createImmutable("      \"especialidad\": \"Dermatología Pediátrica\",\n"),RemoteObject.createImmutable("      \"foto_perfil\": \"camila_herrera.png\"\n"),RemoteObject.createImmutable("    },\n"),RemoteObject.createImmutable("    {\n"),RemoteObject.createImmutable("      \"nombre_completo\": \"Dr. Ignacio Fernández Vidal\",\n"),RemoteObject.createImmutable("      \"especialidad\": \"Neurología Pediátrica\",\n"),RemoteObject.createImmutable("      \"foto_perfil\": \"ignacio_fernandez.png\"\n"),RemoteObject.createImmutable("    }\n"),RemoteObject.createImmutable("  ]\n"),RemoteObject.createImmutable("}")));Debug.locals.put("contenido", _contenido);Debug.locals.put("contenido", _contenido);
 BA.debugLineNum = 133;BA.debugLine="File.WriteString(ruta, nombreArchivo, contenido)";
Debug.ShouldStop(16);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(_ruta),(Object)(_nombrearchivo),(Object)(_contenido));
 BA.debugLineNum = 134;BA.debugLine="Log(\"Archivo creado correctamente en: \" & ruta)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1589862",RemoteObject.concat(RemoteObject.createImmutable("Archivo creado correctamente en: "),_ruta),0);
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private Txt_Rut As AutoCompleteEditText";
main.mostCurrent._txt_rut = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Txt_password As AutoCompleteEditText";
main.mostCurrent._txt_password = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
menu_subs_0._process_globals();
registrar_subs_0._process_globals();
modulo_seleccion_subs_0._process_globals();
modulogestion_subs_0._process_globals();
calendario_subs_0._process_globals();
starter_subs_0._process_globals();
verexamenes_subs_0._process_globals();
b4xcollections_subs_0._process_globals();
xuiviewsutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
menu.myClass = BA.getDeviceClass ("b4a.example.menu");
registrar.myClass = BA.getDeviceClass ("b4a.example.registrar");
modulo_seleccion.myClass = BA.getDeviceClass ("b4a.example.modulo_seleccion");
modulogestion.myClass = BA.getDeviceClass ("b4a.example.modulogestion");
calendario.myClass = BA.getDeviceClass ("b4a.example.calendario");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
verexamenes.myClass = BA.getDeviceClass ("b4a.example.verexamenes");
b4xbitset.myClass = BA.getDeviceClass ("b4a.example.b4xbitset");
b4xbytesbuilder.myClass = BA.getDeviceClass ("b4a.example.b4xbytesbuilder");
b4xcache.myClass = BA.getDeviceClass ("b4a.example.b4xcache");
b4xcollections.myClass = BA.getDeviceClass ("b4a.example.b4xcollections");
b4xcomparatorsort.myClass = BA.getDeviceClass ("b4a.example.b4xcomparatorsort");
b4xorderedmap.myClass = BA.getDeviceClass ("b4a.example.b4xorderedmap");
b4xset.myClass = BA.getDeviceClass ("b4a.example.b4xset");
copyonwritelist.myClass = BA.getDeviceClass ("b4a.example.copyonwritelist");
copyonwritemap.myClass = BA.getDeviceClass ("b4a.example.copyonwritemap");
b4xdrawer.myClass = BA.getDeviceClass ("b4a.example.b4xdrawer");
b4xformatter.myClass = BA.getDeviceClass ("b4a.example.b4xformatter");
animatedcounter.myClass = BA.getDeviceClass ("b4a.example.animatedcounter");
anotherprogressbar.myClass = BA.getDeviceClass ("b4a.example.anotherprogressbar");
b4xbreadcrumb.myClass = BA.getDeviceClass ("b4a.example.b4xbreadcrumb");
b4xcolortemplate.myClass = BA.getDeviceClass ("b4a.example.b4xcolortemplate");
b4xcombobox.myClass = BA.getDeviceClass ("b4a.example.b4xcombobox");
b4xdatetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xdatetemplate");
b4xdialog.myClass = BA.getDeviceClass ("b4a.example.b4xdialog");
b4xfloattextfield.myClass = BA.getDeviceClass ("b4a.example.b4xfloattextfield");
b4ximageview.myClass = BA.getDeviceClass ("b4a.example.b4ximageview");
b4xinputtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xinputtemplate");
b4xlisttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlisttemplate");
b4xloadingindicator.myClass = BA.getDeviceClass ("b4a.example.b4xloadingindicator");
b4xlongtexttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlongtexttemplate");
b4xplusminus.myClass = BA.getDeviceClass ("b4a.example.b4xplusminus");
b4xprogressdialog.myClass = BA.getDeviceClass ("b4a.example.b4xprogressdialog");
b4xradiobutton.myClass = BA.getDeviceClass ("b4a.example.b4xradiobutton");
b4xsearchtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsearchtemplate");
b4xseekbar.myClass = BA.getDeviceClass ("b4a.example.b4xseekbar");
b4xsignaturetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsignaturetemplate");
b4xswitch.myClass = BA.getDeviceClass ("b4a.example.b4xswitch");
b4xtimedtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xtimedtemplate");
madewithlove.myClass = BA.getDeviceClass ("b4a.example.madewithlove");
roundslider.myClass = BA.getDeviceClass ("b4a.example.roundslider");
scrollinglabel.myClass = BA.getDeviceClass ("b4a.example.scrollinglabel");
swiftbutton.myClass = BA.getDeviceClass ("b4a.example.swiftbutton");
xuiviewsutils.myClass = BA.getDeviceClass ("b4a.example.xuiviewsutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 22;BA.debugLine="Type Usuario(Rut As String, Contrasena As String)";
;
 //BA.debugLineNum = 23;BA.debugLine="Public UsuarioActivo As Usuario";
main._usuarioactivo = RemoteObject.createNew ("b4a.example.main._usuario");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}