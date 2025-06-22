package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class modulo_seleccion_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"VistaElegirHora\")";
Debug.ShouldStop(16777216);
modulo_seleccion.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("VistaElegirHora")),modulo_seleccion.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="CargarDoctores";
Debug.ShouldStop(67108864);
_cargardoctores();
 BA.debugLineNum = 28;BA.debugLine="LlenarSpinner";
Debug.ShouldStop(134217728);
_llenarspinner();
 BA.debugLineNum = 29;BA.debugLine="Spiner_especialidad.SelectedIndex = 0 ' Disparar";
Debug.ShouldStop(268435456);
modulo_seleccion.mostCurrent._spiner_especialidad.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addclickeventtopanel(RemoteObject _p) throws Exception{
try {
		Debug.PushSubsStack("AddClickEventToPanel (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,169);
if (RapidSub.canDelegate("addclickeventtopanel")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","addclickeventtopanel", _p);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _eventname = RemoteObject.createImmutable("");
RemoteObject _pe = RemoteObject.declareNull("Object");
Debug.locals.put("p", _p);
 BA.debugLineNum = 169;BA.debugLine="Sub AddClickEventToPanel(p As B4XView)";
Debug.ShouldStop(256);
 BA.debugLineNum = 170;BA.debugLine="Dim jo As JavaObject = p";
Debug.ShouldStop(512);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _p.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 171;BA.debugLine="jo.RunMethod(\"setClickable\", Array(True))";
Debug.ShouldStop(1024);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setClickable")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(modulo_seleccion.mostCurrent.__c.getField(true,"True"))})));
 BA.debugLineNum = 172;BA.debugLine="Dim eventName As String = \"DoctorPanel\"";
Debug.ShouldStop(2048);
_eventname = BA.ObjectToString("DoctorPanel");Debug.locals.put("eventName", _eventname);Debug.locals.put("eventName", _eventname);
 BA.debugLineNum = 173;BA.debugLine="Dim pe As Object = jo.CreateEvent(\"android.vie";
Debug.ShouldStop(4096);
_pe = _jo.runMethod(false,"CreateEvent",modulo_seleccion.processBA,(Object)(BA.ObjectToString("android.view.View.OnClickListener")),(Object)(_eventname),(Object)((modulo_seleccion.mostCurrent.__c.getField(true,"False"))));Debug.locals.put("pe", _pe);Debug.locals.put("pe", _pe);
 BA.debugLineNum = 174;BA.debugLine="jo.RunMethod(\"setOnClickListener\", Array(pe))";
Debug.ShouldStop(8192);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setOnClickListener")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_pe})));
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_elegirfecha_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_elegirFecha_Click (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,77);
if (RapidSub.canDelegate("btn_elegirfecha_click")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","btn_elegirfecha_click");}
 BA.debugLineNum = 77;BA.debugLine="Private Sub Btn_elegirFecha_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="ShowDatePickerDialog";
Debug.ShouldStop(8192);
_showdatepickerdialog();
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_guardaratencion_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_guardarAtencion_Click (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,109);
if (RapidSub.canDelegate("btn_guardaratencion_click")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","btn_guardaratencion_click");}
RemoteObject _rut = RemoteObject.createImmutable("");
RemoteObject _atencion = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _listaatenciones = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _generador = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
 BA.debugLineNum = 109;BA.debugLine="Sub Btn_guardarAtencion_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="If DoctorSeleccionado.IsInitialized = False Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",modulo_seleccion.mostCurrent._doctorseleccionado.runMethod(true,"IsInitialized"),modulo_seleccion.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 111;BA.debugLine="ToastMessageShow(\"Selecciona un doctor.\", True)";
Debug.ShouldStop(16384);
modulo_seleccion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Selecciona un doctor.")),(Object)(modulo_seleccion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 112;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 114;BA.debugLine="If FechaSeleccionada = \"\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",modulo_seleccion.mostCurrent._fechaseleccionada,BA.ObjectToString(""))) { 
 BA.debugLineNum = 115;BA.debugLine="ToastMessageShow(\"Selecciona una fecha.\", True)";
Debug.ShouldStop(262144);
modulo_seleccion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Selecciona una fecha.")),(Object)(modulo_seleccion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 116;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 118;BA.debugLine="Dim Rut As String = Main.UsuarioActivo.Rut";
Debug.ShouldStop(2097152);
_rut = modulo_seleccion.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ );Debug.locals.put("Rut", _rut);Debug.locals.put("Rut", _rut);
 BA.debugLineNum = 119;BA.debugLine="Dim atencion As Map";
Debug.ShouldStop(4194304);
_atencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("atencion", _atencion);
 BA.debugLineNum = 120;BA.debugLine="atencion.Initialize";
Debug.ShouldStop(8388608);
_atencion.runVoidMethod ("Initialize");
 BA.debugLineNum = 121;BA.debugLine="atencion.Put(\"rut_paciente\", Rut)";
Debug.ShouldStop(16777216);
_atencion.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("rut_paciente"))),(Object)((_rut)));
 BA.debugLineNum = 122;BA.debugLine="atencion.Put(\"nombre_medico\", DoctorSeleccionado.";
Debug.ShouldStop(33554432);
_atencion.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("nombre_medico"))),(Object)(modulo_seleccion.mostCurrent._doctorseleccionado.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre_completo"))))));
 BA.debugLineNum = 123;BA.debugLine="atencion.Put(\"especialidad\", DoctorSeleccionado.G";
Debug.ShouldStop(67108864);
_atencion.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("especialidad"))),(Object)(modulo_seleccion.mostCurrent._doctorseleccionado.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("especialidad"))))));
 BA.debugLineNum = 124;BA.debugLine="atencion.Put(\"fecha_atencion\", FechaSeleccionada)";
Debug.ShouldStop(134217728);
_atencion.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("fecha_atencion"))),(Object)((modulo_seleccion.mostCurrent._fechaseleccionada)));
 BA.debugLineNum = 126;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(536870912);
_ruta = modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 127;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
Debug.ShouldStop(1073741824);
_archivo = BA.ObjectToString("atenciones.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 129;BA.debugLine="Dim listaAtenciones As List";
Debug.ShouldStop(1);
_listaatenciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("listaAtenciones", _listaatenciones);
 BA.debugLineNum = 130;BA.debugLine="If File.Exists(ruta, archivo) Then";
Debug.ShouldStop(2);
if (modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_ruta),(Object)(_archivo)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 131;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(4);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 132;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo)";
Debug.ShouldStop(8);
_parser.runVoidMethod ("Initialize",(Object)(modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_archivo))));
 BA.debugLineNum = 133;BA.debugLine="listaAtenciones = parser.NextArray";
Debug.ShouldStop(16);
_listaatenciones = _parser.runMethod(false,"NextArray");Debug.locals.put("listaAtenciones", _listaatenciones);
 }else {
 BA.debugLineNum = 135;BA.debugLine="listaAtenciones.Initialize";
Debug.ShouldStop(64);
_listaatenciones.runVoidMethod ("Initialize");
 };
 BA.debugLineNum = 138;BA.debugLine="listaAtenciones.Add(atencion)";
Debug.ShouldStop(512);
_listaatenciones.runVoidMethod ("Add",(Object)((_atencion.getObject())));
 BA.debugLineNum = 140;BA.debugLine="Dim generador As JSONGenerator";
Debug.ShouldStop(2048);
_generador = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("generador", _generador);
 BA.debugLineNum = 141;BA.debugLine="generador.Initialize2(listaAtenciones)";
Debug.ShouldStop(4096);
_generador.runVoidMethod ("Initialize2",(Object)(_listaatenciones));
 BA.debugLineNum = 142;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
Debug.ShouldStop(8192);
modulo_seleccion.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(_ruta),(Object)(_archivo),(Object)(_generador.runMethod(true,"ToString")));
 BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(\"Atención guardada correctamente";
Debug.ShouldStop(16384);
modulo_seleccion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Atención guardada correctamente")),(Object)(modulo_seleccion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 144;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
modulo_seleccion.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _cargardoctores() throws Exception{
try {
		Debug.PushSubsStack("CargarDoctores (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,32);
if (RapidSub.canDelegate("cargardoctores")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","cargardoctores");}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _nombrearchivo = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 32;BA.debugLine="Sub CargarDoctores";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(1);
_ruta = modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 34;BA.debugLine="Dim nombreArchivo As String = \"doctores.json\"";
Debug.ShouldStop(2);
_nombrearchivo = BA.ObjectToString("doctores.json");Debug.locals.put("nombreArchivo", _nombrearchivo);Debug.locals.put("nombreArchivo", _nombrearchivo);
 BA.debugLineNum = 36;BA.debugLine="If File.Exists(ruta, nombreArchivo) = False Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_ruta),(Object)(_nombrearchivo)),modulo_seleccion.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 37;BA.debugLine="ToastMessageShow(\"Archivo de doctores no encontr";
Debug.ShouldStop(16);
modulo_seleccion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Archivo de doctores no encontrado.")),(Object)(modulo_seleccion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 38;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 41;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(256);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 42;BA.debugLine="parser.Initialize(File.ReadString(ruta, nombreArc";
Debug.ShouldStop(512);
_parser.runVoidMethod ("Initialize",(Object)(modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_nombrearchivo))));
 BA.debugLineNum = 44;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(2048);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 45;BA.debugLine="doctoresList = root.Get(\"doctores\") ' List<Map>";
Debug.ShouldStop(4096);
modulo_seleccion.mostCurrent._doctoreslist = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("doctores")))));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createdoctoritem(RemoteObject _doctor) throws Exception{
try {
		Debug.PushSubsStack("CreateDoctorItem (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,146);
if (RapidSub.canDelegate("createdoctoritem")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","createdoctoritem", _doctor);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _ruta = RemoteObject.createImmutable("");
Debug.locals.put("doctor", _doctor);
 BA.debugLineNum = 146;BA.debugLine="Sub CreateDoctorItem(doctor As Map) As Panel";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(262144);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = modulo_seleccion.mostCurrent._xui.runMethod(false,"CreatePanel",modulo_seleccion.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 148;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsV";
Debug.ShouldStop(524288);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(modulo_seleccion.mostCurrent._listadoctores.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(modulo_seleccion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))));
 BA.debugLineNum = 149;BA.debugLine="p.LoadLayout(\"VistaListaDoctores\")";
Debug.ShouldStop(1048576);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("VistaListaDoctores")),modulo_seleccion.mostCurrent.activityBA);
 BA.debugLineNum = 152;BA.debugLine="Lbl_nombre.Text = doctor.Get(\"nombre_completo\"";
Debug.ShouldStop(8388608);
modulo_seleccion.mostCurrent._lbl_nombre.runMethod(true,"setText",BA.ObjectToCharSequence(_doctor.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre_completo"))))));
 BA.debugLineNum = 153;BA.debugLine="Lbl_especialidad.Text = doctor.Get(\"especialid";
Debug.ShouldStop(16777216);
modulo_seleccion.mostCurrent._lbl_especialidad.runMethod(true,"setText",BA.ObjectToCharSequence(_doctor.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("especialidad"))))));
 BA.debugLineNum = 155;BA.debugLine="Dim ruta As String = doctor.Get(\"foto_perfil\")";
Debug.ShouldStop(67108864);
_ruta = BA.ObjectToString(_doctor.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("foto_perfil")))));Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 156;BA.debugLine="If File.Exists(File.DirAssets, ruta) Then";
Debug.ShouldStop(134217728);
if (modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_ruta)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 157;BA.debugLine="IMG_Doc.Bitmap = LoadBitmap(File.DirAssets";
Debug.ShouldStop(268435456);
modulo_seleccion.mostCurrent._img_doc.runMethod(false,"setBitmap",(modulo_seleccion.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_ruta)).getObject()));
 }else {
 BA.debugLineNum = 159;BA.debugLine="IMG_Doc.Bitmap = LoadBitmapSample(File.Dir";
Debug.ShouldStop(1073741824);
modulo_seleccion.mostCurrent._img_doc.runMethod(false,"setBitmap",(modulo_seleccion.mostCurrent.__c.runMethod(false,"LoadBitmapSample",(Object)(modulo_seleccion.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("default.png")),(Object)(modulo_seleccion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(modulo_seleccion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))))).getObject()));
 };
 BA.debugLineNum = 163;BA.debugLine="p.Tag = doctor";
Debug.ShouldStop(4);
_p.runMethod(false,"setTag",(_doctor.getObject()));
 BA.debugLineNum = 164;BA.debugLine="AddClickEventToPanel(p)";
Debug.ShouldStop(8);
_addclickeventtopanel(_p);
 BA.debugLineNum = 166;BA.debugLine="Return p";
Debug.ShouldStop(32);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _p.getObject());
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _doctorpanel_event(RemoteObject _methodname,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("DoctorPanel_Event (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,177);
if (RapidSub.canDelegate("doctorpanel_event")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","doctorpanel_event", _methodname, _args);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _panelclicked = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("MethodName", _methodname);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 177;BA.debugLine="Sub DoctorPanel_Event (MethodName As String, Args(";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="Dim v As View = Args(0)";
Debug.ShouldStop(131072);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
_v = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _args.getArrayElement(false,BA.numberCast(int.class, 0)));Debug.locals.put("v", _v);Debug.locals.put("v", _v);
 BA.debugLineNum = 179;BA.debugLine="Dim panelClicked As Panel = v";
Debug.ShouldStop(262144);
_panelclicked = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_panelclicked = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _v.getObject());Debug.locals.put("panelClicked", _panelclicked);Debug.locals.put("panelClicked", _panelclicked);
 BA.debugLineNum = 180;BA.debugLine="DoctorSeleccionado = panelClicked.Tag";
Debug.ShouldStop(524288);
modulo_seleccion.mostCurrent._doctorseleccionado = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _panelclicked.runMethod(false,"getTag"));
 BA.debugLineNum = 181;BA.debugLine="ToastMessageShow(\"Doctor seleccionado: \" & Doc";
Debug.ShouldStop(1048576);
modulo_seleccion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Doctor seleccionado: "),modulo_seleccion.mostCurrent._doctorseleccionado.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre_completo"))))))),(Object)(modulo_seleccion.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 182;BA.debugLine="Return Null";
Debug.ShouldStop(2097152);
if (true) return modulo_seleccion.mostCurrent.__c.getField(false,"Null");
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
 //BA.debugLineNum = 13;BA.debugLine="Private ListaDoctores As CustomListView";
modulo_seleccion.mostCurrent._listadoctores = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 14;BA.debugLine="Private Spiner_especialidad As Spinner";
modulo_seleccion.mostCurrent._spiner_especialidad = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
modulo_seleccion.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Private doctoresList As List";
modulo_seleccion.mostCurrent._doctoreslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 17;BA.debugLine="Private Lbl_nombre As Label";
modulo_seleccion.mostCurrent._lbl_nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Lbl_especialidad As Label";
modulo_seleccion.mostCurrent._lbl_especialidad = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private IMG_Doc As ImageView";
modulo_seleccion.mostCurrent._img_doc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private DoctorSeleccionado As Map";
modulo_seleccion.mostCurrent._doctorseleccionado = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 21;BA.debugLine="Dim FechaSeleccionada As String";
modulo_seleccion.mostCurrent._fechaseleccionada = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _llenarspinner() throws Exception{
try {
		Debug.PushSubsStack("LlenarSpinner (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,48);
if (RapidSub.canDelegate("llenarspinner")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","llenarspinner");}
RemoteObject _especialidadesset = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _doctor = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _esp = RemoteObject.createImmutable("");
RemoteObject _key = RemoteObject.createImmutable("");
 BA.debugLineNum = 48;BA.debugLine="Sub LlenarSpinner";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Dim especialidadesSet As Map";
Debug.ShouldStop(65536);
_especialidadesset = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("especialidadesSet", _especialidadesset);
 BA.debugLineNum = 50;BA.debugLine="especialidadesSet.Initialize";
Debug.ShouldStop(131072);
_especialidadesset.runVoidMethod ("Initialize");
 BA.debugLineNum = 52;BA.debugLine="For Each doctor As Map In doctoresList";
Debug.ShouldStop(524288);
_doctor = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group3 = modulo_seleccion.mostCurrent._doctoreslist;
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_doctor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group3.runMethod(false,"Get",index3));Debug.locals.put("doctor", _doctor);
Debug.locals.put("doctor", _doctor);
 BA.debugLineNum = 53;BA.debugLine="Dim esp As String = doctor.Get(\"especialidad\")";
Debug.ShouldStop(1048576);
_esp = BA.ObjectToString(_doctor.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("especialidad")))));Debug.locals.put("esp", _esp);Debug.locals.put("esp", _esp);
 BA.debugLineNum = 54;BA.debugLine="especialidadesSet.Put(esp, \"\")";
Debug.ShouldStop(2097152);
_especialidadesset.runVoidMethod ("Put",(Object)((_esp)),(Object)((RemoteObject.createImmutable(""))));
 }
}Debug.locals.put("doctor", _doctor);
;
 BA.debugLineNum = 57;BA.debugLine="Spiner_especialidad.Clear";
Debug.ShouldStop(16777216);
modulo_seleccion.mostCurrent._spiner_especialidad.runVoidMethod ("Clear");
 BA.debugLineNum = 58;BA.debugLine="For Each key As String In especialidadesSet.Keys";
Debug.ShouldStop(33554432);
{
final RemoteObject group8 = _especialidadesset.runMethod(false,"Keys");
final int groupLen8 = group8.runMethod(true,"getSize").<Integer>get()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_key = BA.ObjectToString(group8.runMethod(false,"Get",index8));Debug.locals.put("key", _key);
Debug.locals.put("key", _key);
 BA.debugLineNum = 59;BA.debugLine="Spiner_especialidad.Add(key)";
Debug.ShouldStop(67108864);
modulo_seleccion.mostCurrent._spiner_especialidad.runVoidMethod ("Add",(Object)(_key));
 }
}Debug.locals.put("key", _key);
;
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mostrardoctoresporespecialidad(RemoteObject _especialidad) throws Exception{
try {
		Debug.PushSubsStack("MostrarDoctoresPorEspecialidad (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,67);
if (RapidSub.canDelegate("mostrardoctoresporespecialidad")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","mostrardoctoresporespecialidad", _especialidad);}
RemoteObject _doctor = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("especialidad", _especialidad);
 BA.debugLineNum = 67;BA.debugLine="Sub MostrarDoctoresPorEspecialidad(especialidad As";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="ListaDoctores.Clear";
Debug.ShouldStop(8);
modulo_seleccion.mostCurrent._listadoctores.runVoidMethod ("_clear");
 BA.debugLineNum = 70;BA.debugLine="For Each doctor As Map In doctoresList";
Debug.ShouldStop(32);
_doctor = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group2 = modulo_seleccion.mostCurrent._doctoreslist;
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_doctor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group2.runMethod(false,"Get",index2));Debug.locals.put("doctor", _doctor);
Debug.locals.put("doctor", _doctor);
 BA.debugLineNum = 71;BA.debugLine="If doctor.Get(\"especialidad\") = especialidad The";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_doctor.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("especialidad")))),(_especialidad))) { 
 BA.debugLineNum = 72;BA.debugLine="ListaDoctores.Add(CreateDoctorItem(doctor), \"\")";
Debug.ShouldStop(128);
modulo_seleccion.mostCurrent._listadoctores.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _createdoctoritem(_doctor).getObject()),(Object)((RemoteObject.createImmutable(""))));
 };
 }
}Debug.locals.put("doctor", _doctor);
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _recibirfecha(RemoteObject _fecha) throws Exception{
try {
		Debug.PushSubsStack("RecibirFecha (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,85);
if (RapidSub.canDelegate("recibirfecha")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","recibirfecha", _fecha);}
Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 85;BA.debugLine="Sub RecibirFecha(fecha As String)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="FechaSeleccionada = fecha";
Debug.ShouldStop(2097152);
modulo_seleccion.mostCurrent._fechaseleccionada = _fecha;
 BA.debugLineNum = 87;BA.debugLine="Log(\"Fecha: \" & FechaSeleccionada)";
Debug.ShouldStop(4194304);
modulo_seleccion.mostCurrent.__c.runVoidMethod ("LogImpl","12752514",RemoteObject.concat(RemoteObject.createImmutable("Fecha: "),modulo_seleccion.mostCurrent._fechaseleccionada),0);
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showdatepickerdialog() throws Exception{
try {
		Debug.PushSubsStack("ShowDatePickerDialog (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,80);
if (RapidSub.canDelegate("showdatepickerdialog")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","showdatepickerdialog");}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 80;BA.debugLine="Sub ShowDatePickerDialog";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(65536);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 82;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(131072);
_jo.runVoidMethod ("InitializeContext",modulo_seleccion.processBA);
 BA.debugLineNum = 83;BA.debugLine="jo.RunMethod(\"showDatePicker\", Null)";
Debug.ShouldStop(262144);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("showDatePicker")),(Object)((modulo_seleccion.mostCurrent.__c.getField(false,"Null"))));
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _spiner_especialidad_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Spiner_especialidad_ItemClick (modulo_seleccion) ","modulo_seleccion",3,modulo_seleccion.mostCurrent.activityBA,modulo_seleccion.mostCurrent,63);
if (RapidSub.canDelegate("spiner_especialidad_itemclick")) { return b4a.example.modulo_seleccion.remoteMe.runUserSub(false, "modulo_seleccion","spiner_especialidad_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 63;BA.debugLine="Sub Spiner_especialidad_ItemClick (Position As Int";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="MostrarDoctoresPorEspecialidad(Value)";
Debug.ShouldStop(-2147483648);
_mostrardoctoresporespecialidad(BA.ObjectToString(_value));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}