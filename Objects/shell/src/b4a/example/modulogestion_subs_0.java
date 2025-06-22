package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class modulogestion_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"VistaGesionar\")";
Debug.ShouldStop(67108864);
modulogestion.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("VistaGesionar")),modulogestion.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="MostrarAtenciones";
Debug.ShouldStop(134217728);
_mostraratenciones();
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_cancelar_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Cancelar_Click (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,49);
if (RapidSub.canDelegate("btn_cancelar_click")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","btn_cancelar_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _indice = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 49;BA.debugLine="Sub Btn_Cancelar_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(131072);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), modulogestion.mostCurrent.__c.runMethod(false,"Sender",modulogestion.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 51;BA.debugLine="Dim indice As Int = btn.Tag";
Debug.ShouldStop(262144);
_indice = BA.numberCast(int.class, _btn.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);Debug.locals.put("indice", _indice);
 BA.debugLineNum = 52;BA.debugLine="Dim res As Int = Msgbox2(\"¿Deseas cancelar esta c";
Debug.ShouldStop(524288);
_res = modulogestion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("¿Deseas cancelar esta cita?")),(Object)(BA.ObjectToCharSequence("Confirmar")),(Object)(BA.ObjectToString("Sí")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((modulogestion.mostCurrent.__c.getField(false,"Null"))),modulogestion.mostCurrent.activityBA);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 53;BA.debugLine="If res = DialogResponse.POSITIVE Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, modulogestion.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 54;BA.debugLine="EliminarAtencion(indice)";
Debug.ShouldStop(2097152);
_eliminaratencion(_indice);
 };
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
public static RemoteObject  _btn_modificar_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Modificar_Click (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,38);
if (RapidSub.canDelegate("btn_modificar_click")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","btn_modificar_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _indice = RemoteObject.createImmutable(0);
 BA.debugLineNum = 38;BA.debugLine="Sub Btn_Modificar_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(64);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), modulogestion.mostCurrent.__c.runMethod(false,"Sender",modulogestion.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 40;BA.debugLine="Dim indice As Int = btn.Tag";
Debug.ShouldStop(128);
_indice = BA.numberCast(int.class, _btn.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);Debug.locals.put("indice", _indice);
 BA.debugLineNum = 41;BA.debugLine="MostrarDatePickerParaModificar(indice)";
Debug.ShouldStop(256);
_mostrardatepickerparamodificar(_indice);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _eliminaratencion(RemoteObject _indice) throws Exception{
try {
		Debug.PushSubsStack("EliminarAtencion (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,58);
if (RapidSub.canDelegate("eliminaratencion")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","eliminaratencion", _indice);}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _lista = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _generador = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
Debug.locals.put("indice", _indice);
 BA.debugLineNum = 58;BA.debugLine="Sub EliminarAtencion(indice As Int)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(67108864);
_ruta = modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 60;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
Debug.ShouldStop(134217728);
_archivo = BA.ObjectToString("atenciones.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 61;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(268435456);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 62;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
Debug.ShouldStop(536870912);
_parser.runVoidMethod ("Initialize",(Object)(modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_archivo))));
 BA.debugLineNum = 63;BA.debugLine="Dim lista As List = parser.NextArray";
Debug.ShouldStop(1073741824);
_lista = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lista = _parser.runMethod(false,"NextArray");Debug.locals.put("lista", _lista);Debug.locals.put("lista", _lista);
 BA.debugLineNum = 65;BA.debugLine="lista.RemoveAt(indice)";
Debug.ShouldStop(1);
_lista.runVoidMethod ("RemoveAt",(Object)(_indice));
 BA.debugLineNum = 67;BA.debugLine="Dim generador As JSONGenerator";
Debug.ShouldStop(4);
_generador = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("generador", _generador);
 BA.debugLineNum = 68;BA.debugLine="generador.Initialize2(lista)";
Debug.ShouldStop(8);
_generador.runVoidMethod ("Initialize2",(Object)(_lista));
 BA.debugLineNum = 69;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
Debug.ShouldStop(16);
modulogestion.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(_ruta),(Object)(_archivo),(Object)(_generador.runMethod(true,"ToString")));
 BA.debugLineNum = 71;BA.debugLine="ToastMessageShow(\"Cita cancelada\", True)";
Debug.ShouldStop(64);
modulogestion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Cita cancelada")),(Object)(modulogestion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 72;BA.debugLine="MostrarAtenciones";
Debug.ShouldStop(128);
_mostraratenciones();
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
modulogestion.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Private ListaCitas As CustomListView";
modulogestion.mostCurrent._listacitas = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 17;BA.debugLine="Private Btn_Cancelar As Button";
modulogestion.mostCurrent._btn_cancelar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Btn_Editar As Button";
modulogestion.mostCurrent._btn_editar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private Lbl_Fecha As Label";
modulogestion.mostCurrent._lbl_fecha = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Lbl_Medico As Label";
modulogestion.mostCurrent._lbl_medico = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private ListaDoctores As CustomListView";
modulogestion.mostCurrent._listadoctores = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 22;BA.debugLine="Private Btn_Modificar As Button";
modulogestion.mostCurrent._btn_modificar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _listacitas_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListaCitas_ItemClick (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,143);
if (RapidSub.canDelegate("listacitas_itemclick")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","listacitas_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 143;BA.debugLine="Private Sub ListaCitas_ItemClick (Index As Int, Va";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mostraratenciones() throws Exception{
try {
		Debug.PushSubsStack("MostrarAtenciones (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,110);
if (RapidSub.canDelegate("mostraratenciones")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","mostraratenciones");}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _lista = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _rutactual = RemoteObject.createImmutable("");
RemoteObject _indicevisual = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _atencion = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
 BA.debugLineNum = 110;BA.debugLine="Sub MostrarAtenciones";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="ListaDoctores.Clear";
Debug.ShouldStop(16384);
modulogestion.mostCurrent._listadoctores.runVoidMethod ("_clear");
 BA.debugLineNum = 112;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(32768);
_ruta = modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 113;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
Debug.ShouldStop(65536);
_archivo = BA.ObjectToString("atenciones.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 115;BA.debugLine="If File.Exists(ruta, archivo) = False Then Return";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_ruta),(Object)(_archivo)),modulogestion.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 117;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1048576);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 118;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
Debug.ShouldStop(2097152);
_parser.runVoidMethod ("Initialize",(Object)(modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_archivo))));
 BA.debugLineNum = 119;BA.debugLine="Dim lista As List = parser.NextArray";
Debug.ShouldStop(4194304);
_lista = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lista = _parser.runMethod(false,"NextArray");Debug.locals.put("lista", _lista);Debug.locals.put("lista", _lista);
 BA.debugLineNum = 121;BA.debugLine="Dim rutActual As String = Main.UsuarioActivo.Rut";
Debug.ShouldStop(16777216);
_rutactual = modulogestion.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ );Debug.locals.put("rutActual", _rutactual);Debug.locals.put("rutActual", _rutactual);
 BA.debugLineNum = 122;BA.debugLine="Dim indiceVisual As Int = 0";
Debug.ShouldStop(33554432);
_indicevisual = BA.numberCast(int.class, 0);Debug.locals.put("indiceVisual", _indicevisual);Debug.locals.put("indiceVisual", _indicevisual);
 BA.debugLineNum = 124;BA.debugLine="For i = 0 To lista.Size - 1";
Debug.ShouldStop(134217728);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_lista.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 125;BA.debugLine="Dim atencion As Map = lista.Get(i)";
Debug.ShouldStop(268435456);
_atencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_atencion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _lista.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("atencion", _atencion);Debug.locals.put("atencion", _atencion);
 BA.debugLineNum = 126;BA.debugLine="If atencion.Get(\"rut_paciente\") = rutActual Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rut_paciente")))),(_rutactual))) { 
 BA.debugLineNum = 127;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(1073741824);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = modulogestion.mostCurrent._xui.runMethod(false,"CreatePanel",modulogestion.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 128;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsVi";
Debug.ShouldStop(-2147483648);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(modulogestion.mostCurrent._listadoctores.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(modulogestion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 BA.debugLineNum = 129;BA.debugLine="p.LoadLayout(\"VistaMod\")";
Debug.ShouldStop(1);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("VistaMod")),modulogestion.mostCurrent.activityBA);
 BA.debugLineNum = 131;BA.debugLine="Lbl_Medico.Text = atencion.Get(\"nombre_medico\")";
Debug.ShouldStop(4);
modulogestion.mostCurrent._lbl_medico.runMethod(true,"setText",BA.ObjectToCharSequence(_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre_medico"))))));
 BA.debugLineNum = 132;BA.debugLine="Lbl_Fecha.Text = atencion.Get(\"fecha_atencion\")";
Debug.ShouldStop(8);
modulogestion.mostCurrent._lbl_fecha.runMethod(true,"setText",BA.ObjectToCharSequence(_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha_atencion"))))));
 BA.debugLineNum = 135;BA.debugLine="Btn_Modificar.Tag = i";
Debug.ShouldStop(64);
modulogestion.mostCurrent._btn_modificar.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 136;BA.debugLine="Btn_Cancelar.Tag = i";
Debug.ShouldStop(128);
modulogestion.mostCurrent._btn_cancelar.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 138;BA.debugLine="ListaDoctores.Add(p, \"\")";
Debug.ShouldStop(512);
modulogestion.mostCurrent._listadoctores.runVoidMethod ("_add",(Object)(_p),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 139;BA.debugLine="indiceVisual = indiceVisual + 1";
Debug.ShouldStop(1024);
_indicevisual = RemoteObject.solve(new RemoteObject[] {_indicevisual,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("indiceVisual", _indicevisual);
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mostrardatepickerparamodificar(RemoteObject _indice) throws Exception{
try {
		Debug.PushSubsStack("MostrarDatePickerParaModificar (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,44);
if (RapidSub.canDelegate("mostrardatepickerparamodificar")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","mostrardatepickerparamodificar", _indice);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("indice", _indice);
 BA.debugLineNum = 44;BA.debugLine="Sub MostrarDatePickerParaModificar(indice As Int)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(4096);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 46;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(8192);
_jo.runVoidMethod ("InitializeContext",modulogestion.processBA);
 BA.debugLineNum = 47;BA.debugLine="jo.RunMethod(\"mostrarDatePickerModificar\", Array(";
Debug.ShouldStop(16384);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("mostrarDatePickerModificar")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_indice)})));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _recibirfechamodificada(RemoteObject _fecha,RemoteObject _indice) throws Exception{
try {
		Debug.PushSubsStack("RecibirFechaModificada (modulogestion) ","modulogestion",4,modulogestion.mostCurrent.activityBA,modulogestion.mostCurrent,92);
if (RapidSub.canDelegate("recibirfechamodificada")) { return b4a.example.modulogestion.remoteMe.runUserSub(false, "modulogestion","recibirfechamodificada", _fecha, _indice);}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _lista = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _atencion = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _generador = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
Debug.locals.put("fecha", _fecha);
Debug.locals.put("indice", _indice);
 BA.debugLineNum = 92;BA.debugLine="Sub RecibirFechaModificada(fecha As String, indice";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(536870912);
_ruta = modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 95;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
Debug.ShouldStop(1073741824);
_archivo = BA.ObjectToString("atenciones.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 96;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(-2147483648);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 97;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
Debug.ShouldStop(1);
_parser.runVoidMethod ("Initialize",(Object)(modulogestion.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_archivo))));
 BA.debugLineNum = 98;BA.debugLine="Dim lista As List = parser.NextArray";
Debug.ShouldStop(2);
_lista = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lista = _parser.runMethod(false,"NextArray");Debug.locals.put("lista", _lista);Debug.locals.put("lista", _lista);
 BA.debugLineNum = 100;BA.debugLine="Dim atencion As Map = lista.Get(indice)";
Debug.ShouldStop(8);
_atencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_atencion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _lista.runMethod(false,"Get",(Object)(_indice)));Debug.locals.put("atencion", _atencion);Debug.locals.put("atencion", _atencion);
 BA.debugLineNum = 101;BA.debugLine="atencion.Put(\"fecha_atencion\", fecha)";
Debug.ShouldStop(16);
_atencion.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("fecha_atencion"))),(Object)((_fecha)));
 BA.debugLineNum = 103;BA.debugLine="Dim generador As JSONGenerator";
Debug.ShouldStop(64);
_generador = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("generador", _generador);
 BA.debugLineNum = 104;BA.debugLine="generador.Initialize2(lista)";
Debug.ShouldStop(128);
_generador.runVoidMethod ("Initialize2",(Object)(_lista));
 BA.debugLineNum = 105;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
Debug.ShouldStop(256);
modulogestion.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(_ruta),(Object)(_archivo),(Object)(_generador.runMethod(true,"ToString")));
 BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(\"Fecha modificada\", True)";
Debug.ShouldStop(1024);
modulogestion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Fecha modificada")),(Object)(modulogestion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 108;BA.debugLine="MostrarAtenciones";
Debug.ShouldStop(2048);
_mostraratenciones();
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}