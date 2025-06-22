package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class menu_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"Menuvista\")";
Debug.ShouldStop(1048576);
menu.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Menuvista")),menu.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="VerificarProximaAtencion";
Debug.ShouldStop(2097152);
_verificarproximaatencion();
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,32);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,25);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","activity_resume");}
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
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
public static RemoteObject  _btn_calendario_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_calendario_Click (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,78);
if (RapidSub.canDelegate("btn_calendario_click")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","btn_calendario_click");}
 BA.debugLineNum = 78;BA.debugLine="Private Sub Btn_calendario_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="StartActivity(Calendario)";
Debug.ShouldStop(16384);
menu.mostCurrent.__c.runVoidMethod ("StartActivity",menu.processBA,(Object)((menu.mostCurrent._calendario.getObject())));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_fecha_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Fecha_Click (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,37);
if (RapidSub.canDelegate("btn_fecha_click")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","btn_fecha_click");}
 BA.debugLineNum = 37;BA.debugLine="Private Sub Btn_Fecha_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="StartActivity(Modulo_Seleccion)";
Debug.ShouldStop(32);
menu.mostCurrent.__c.runVoidMethod ("StartActivity",menu.processBA,(Object)((menu.mostCurrent._modulo_seleccion.getObject())));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_gestionar_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Gestionar_Click (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,41);
if (RapidSub.canDelegate("btn_gestionar_click")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","btn_gestionar_click");}
 BA.debugLineNum = 41;BA.debugLine="Private Sub Btn_Gestionar_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="StartActivity(\"ModuloGestion\")";
Debug.ShouldStop(512);
menu.mostCurrent.__c.runVoidMethod ("StartActivity",menu.processBA,(Object)((RemoteObject.createImmutable("ModuloGestion"))));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private FechaSeleccionada As String";
menu.mostCurrent._fechaseleccionada = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim xui As XUI";
menu.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mostrarmensajeshock(RemoteObject _titulo,RemoteObject _mensaje) throws Exception{
try {
		Debug.PushSubsStack("MostrarMensajeShock (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,29);
if (RapidSub.canDelegate("mostrarmensajeshock")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","mostrarmensajeshock", _titulo, _mensaje);}
Debug.locals.put("titulo", _titulo);
Debug.locals.put("mensaje", _mensaje);
 BA.debugLineNum = 29;BA.debugLine="Sub MostrarMensajeShock(titulo As String, mensaje";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="xui.MsgboxAsync(mensaje, titulo)";
Debug.ShouldStop(536870912);
menu.mostCurrent._xui.runVoidMethod ("MsgboxAsync",menu.processBA,(Object)(BA.ObjectToCharSequence(_mensaje)),(Object)(BA.ObjectToCharSequence(_titulo)));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _verificarproximaatencion() throws Exception{
try {
		Debug.PushSubsStack("VerificarProximaAtencion (menu) ","menu",1,menu.mostCurrent.activityBA,menu.mostCurrent,44);
if (RapidSub.canDelegate("verificarproximaatencion")) { return b4a.example.menu.remoteMe.runUserSub(false, "menu","verificarproximaatencion");}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _lista = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _rutactual = RemoteObject.createImmutable("");
RemoteObject _hoy = RemoteObject.createImmutable(0L);
RemoteObject _mañana = RemoteObject.createImmutable(0L);
RemoteObject _atencion = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fechatexto = RemoteObject.createImmutable("");
RemoteObject _fechaticks = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 44;BA.debugLine="Sub VerificarProximaAtencion";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(4096);
_ruta = menu.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 46;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
Debug.ShouldStop(8192);
_archivo = BA.ObjectToString("atenciones.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 47;BA.debugLine="If File.Exists(ruta, archivo) = False Then Return";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",menu.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_ruta),(Object)(_archivo)),menu.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 49;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(65536);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 50;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
Debug.ShouldStop(131072);
_parser.runVoidMethod ("Initialize",(Object)(menu.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_archivo))));
 BA.debugLineNum = 51;BA.debugLine="Dim lista As List = parser.NextArray";
Debug.ShouldStop(262144);
_lista = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lista = _parser.runMethod(false,"NextArray");Debug.locals.put("lista", _lista);Debug.locals.put("lista", _lista);
 BA.debugLineNum = 52;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
Debug.ShouldStop(524288);
menu.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 53;BA.debugLine="Dim rutActual As String = Main.UsuarioActivo.Rut";
Debug.ShouldStop(1048576);
_rutactual = menu.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ );Debug.locals.put("rutActual", _rutactual);Debug.locals.put("rutActual", _rutactual);
 BA.debugLineNum = 55;BA.debugLine="Dim hoy As Long = DateTime.Now";
Debug.ShouldStop(4194304);
_hoy = menu.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("hoy", _hoy);Debug.locals.put("hoy", _hoy);
 BA.debugLineNum = 56;BA.debugLine="Dim mañana As Long = hoy + DateTime.TicksPerDay";
Debug.ShouldStop(8388608);
_mañana = RemoteObject.solve(new RemoteObject[] {_hoy,menu.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "+",1, 2);Debug.locals.put("mañana", _mañana);Debug.locals.put("mañana", _mañana);
 BA.debugLineNum = 58;BA.debugLine="For Each atencion As Map In lista";
Debug.ShouldStop(33554432);
_atencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group11 = _lista;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_atencion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group11.runMethod(false,"Get",index11));Debug.locals.put("atencion", _atencion);
Debug.locals.put("atencion", _atencion);
 BA.debugLineNum = 59;BA.debugLine="If atencion.Get(\"rut_paciente\") = rutActual Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rut_paciente")))),(_rutactual))) { 
 BA.debugLineNum = 60;BA.debugLine="Dim fechaTexto As String = atencion.Get(\"fecha_";
Debug.ShouldStop(134217728);
_fechatexto = BA.ObjectToString(_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha_atencion")))));Debug.locals.put("fechaTexto", _fechatexto);Debug.locals.put("fechaTexto", _fechatexto);
 BA.debugLineNum = 61;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 62;BA.debugLine="Dim fechaTicks As Long = DateTime.DateParse(fe";
Debug.ShouldStop(536870912);
_fechaticks = menu.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechatexto));Debug.locals.put("fechaTicks", _fechaticks);Debug.locals.put("fechaTicks", _fechaticks);
 BA.debugLineNum = 63;BA.debugLine="If DateUtils.IsSameDay(fechaTicks, hoy) Then";
Debug.ShouldStop(1073741824);
if (menu.mostCurrent._dateutils.runMethod(true,"_issameday",menu.mostCurrent.activityBA,(Object)(_fechaticks),(Object)(_hoy)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 64;BA.debugLine="MostrarMensajeShock(\"¡Tienes una atención méd";
Debug.ShouldStop(-2147483648);
_mostrarmensajeshock(BA.ObjectToString("¡Tienes una atención médica hoy!"),RemoteObject.concat(RemoteObject.createImmutable("Tienes una hora agendada para el dia: "),_fechatexto));
 BA.debugLineNum = 65;BA.debugLine="Return";
Debug.ShouldStop(1);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 }else 
{ BA.debugLineNum = 66;BA.debugLine="Else If DateUtils.IsSameDay(fechaTicks, mañana";
Debug.ShouldStop(2);
if (menu.mostCurrent._dateutils.runMethod(true,"_issameday",menu.mostCurrent.activityBA,(Object)(_fechaticks),(Object)(_mañana)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 67;BA.debugLine="MostrarMensajeShock(\"¡Tienes una atención méd";
Debug.ShouldStop(4);
_mostrarmensajeshock(BA.ObjectToString("¡Tienes una atención médica mañana!"),RemoteObject.concat(RemoteObject.createImmutable("Tienes una hora agendada para el dia: "),_fechatexto));
 BA.debugLineNum = 68;BA.debugLine="Return";
Debug.ShouldStop(8);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e24) {
			BA.rdebugUtils.runVoidMethod("setLastException",menu.processBA, e24.toString()); BA.debugLineNum = 71;BA.debugLine="Log(\"Error al interpretar fecha: \" & fechaText";
Debug.ShouldStop(64);
menu.mostCurrent.__c.runVoidMethod ("LogImpl","21179675",RemoteObject.concat(RemoteObject.createImmutable("Error al interpretar fecha: "),_fechatexto),0);
 };
 };
 }
}Debug.locals.put("atencion", _atencion);
;
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}