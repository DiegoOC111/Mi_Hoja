package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class verexamenes_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"VistaExamenes\")";
Debug.ShouldStop(65536);
verexamenes.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("VistaExamenes")),verexamenes.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="CrearArchivoExamenesSiNoExiste";
Debug.ShouldStop(131072);
_creararchivoexamenessinoexiste();
 BA.debugLineNum = 51;BA.debugLine="CargarExamenes";
Debug.ShouldStop(262144);
_cargarexamenes();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,101);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 101;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Resume (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,97);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","activity_resume");}
 BA.debugLineNum = 97;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_cerrar_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_cerrar_Click (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,106);
if (RapidSub.canDelegate("btn_cerrar_click")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","btn_cerrar_click");}
 BA.debugLineNum = 106;BA.debugLine="Private Sub Btn_cerrar_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 107;BA.debugLine="PanelEXA.Visible  = False";
Debug.ShouldStop(1024);
verexamenes.mostCurrent._panelexa.runMethod(true,"setVisible",verexamenes.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="MainPanel.Visible = True";
Debug.ShouldStop(2048);
verexamenes.mostCurrent._mainpanel.runMethod(true,"setVisible",verexamenes.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _btn_ver_click() throws Exception{
try {
		Debug.PushSubsStack("Btn_Ver_Click (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,111);
if (RapidSub.canDelegate("btn_ver_click")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","btn_ver_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _ruta = RemoteObject.createImmutable("");
 BA.debugLineNum = 111;BA.debugLine="Private Sub Btn_Ver_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(32768);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), verexamenes.mostCurrent.__c.runMethod(false,"Sender",verexamenes.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 113;BA.debugLine="Dim ruta As String = btn.Tag";
Debug.ShouldStop(65536);
_ruta = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 115;BA.debugLine="If File.Exists(File.DirAssets, ruta) Then";
Debug.ShouldStop(262144);
if (verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_ruta)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 116;BA.debugLine="PanelEXA.Visible = True";
Debug.ShouldStop(524288);
verexamenes.mostCurrent._panelexa.runMethod(true,"setVisible",verexamenes.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 118;BA.debugLine="MainPanel.Visible = False";
Debug.ShouldStop(2097152);
verexamenes.mostCurrent._mainpanel.runMethod(true,"setVisible",verexamenes.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 120;BA.debugLine="ImageViewer.Bitmap = LoadBitmap(File.DirAssets,";
Debug.ShouldStop(8388608);
verexamenes.mostCurrent._imageviewer.runMethod(false,"setBitmap",(verexamenes.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_ruta)).getObject()));
 }else {
 BA.debugLineNum = 122;BA.debugLine="ToastMessageShow(\"Imagen no encontrada: \" & ruta";
Debug.ShouldStop(33554432);
verexamenes.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Imagen no encontrada: "),_ruta))),(Object)(verexamenes.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnver_click() throws Exception{
try {
		Debug.PushSubsStack("BtnVer_Click (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,93);
if (RapidSub.canDelegate("btnver_click")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","btnver_click");}
 BA.debugLineNum = 93;BA.debugLine="Sub BtnVer_Click";
Debug.ShouldStop(268435456);
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
public static RemoteObject  _cargarexamenes() throws Exception{
try {
		Debug.PushSubsStack("CargarExamenes (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,54);
if (RapidSub.canDelegate("cargarexamenes")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","cargarexamenes");}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _examen = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 54;BA.debugLine="Sub CargarExamenes";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="listaExamenes.Initialize";
Debug.ShouldStop(4194304);
verexamenes.mostCurrent._listaexamenes.runVoidMethod ("Initialize");
 BA.debugLineNum = 56;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(8388608);
_ruta = verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 57;BA.debugLine="Dim archivo As String = \"examenes.json\"";
Debug.ShouldStop(16777216);
_archivo = BA.ObjectToString("examenes.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 59;BA.debugLine="If File.Exists(ruta, archivo) = False Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_ruta),(Object)(_archivo)),verexamenes.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(\"No se encontró el archivo de e";
Debug.ShouldStop(134217728);
verexamenes.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No se encontró el archivo de exámenes.")),(Object)(verexamenes.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 61;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 64;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(-2147483648);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 65;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
Debug.ShouldStop(1);
_parser.runVoidMethod ("Initialize",(Object)(verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(_ruta),(Object)(_archivo))));
 BA.debugLineNum = 66;BA.debugLine="listaExamenes = parser.NextArray";
Debug.ShouldStop(2);
verexamenes.mostCurrent._listaexamenes = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 68;BA.debugLine="CLV_Examenes.Clear";
Debug.ShouldStop(8);
verexamenes.mostCurrent._clv_examenes.runVoidMethod ("_clear");
 BA.debugLineNum = 70;BA.debugLine="For Each examen As Map In listaExamenes";
Debug.ShouldStop(32);
_examen = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group12 = verexamenes.mostCurrent._listaexamenes;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_examen = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group12.runMethod(false,"Get",index12));Debug.locals.put("examen", _examen);
Debug.locals.put("examen", _examen);
 BA.debugLineNum = 71;BA.debugLine="If examen.Get(\"Rut\") = Main.UsuarioActivo.Rut Th";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_examen.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Rut")))),(verexamenes.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ )))) { 
 BA.debugLineNum = 72;BA.debugLine="CLV_Examenes.Add(CreateItemExamen(examen), \"\")";
Debug.ShouldStop(128);
verexamenes.mostCurrent._clv_examenes.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _createitemexamen(_examen).getObject()),(Object)((RemoteObject.createImmutable(""))));
 };
 }
}Debug.locals.put("examen", _examen);
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
public static RemoteObject  _creararchivoexamenessinoexiste() throws Exception{
try {
		Debug.PushSubsStack("CrearArchivoExamenesSiNoExiste (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,23);
if (RapidSub.canDelegate("creararchivoexamenessinoexiste")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","creararchivoexamenessinoexiste");}
RemoteObject _ruta = RemoteObject.createImmutable("");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _examenes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _ex = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _gen = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
 BA.debugLineNum = 23;BA.debugLine="Sub CrearArchivoExamenesSiNoExiste";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 24;BA.debugLine="Dim ruta As String = File.DirInternal";
Debug.ShouldStop(8388608);
_ruta = verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("ruta", _ruta);Debug.locals.put("ruta", _ruta);
 BA.debugLineNum = 25;BA.debugLine="Dim archivo As String = \"examenes.json\"";
Debug.ShouldStop(16777216);
_archivo = BA.ObjectToString("examenes.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 27;BA.debugLine="If File.Exists(ruta, archivo) Then Return ' Ya ex";
Debug.ShouldStop(67108864);
if (verexamenes.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_ruta),(Object)(_archivo)).<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 29;BA.debugLine="Dim examenes As List";
Debug.ShouldStop(268435456);
_examenes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("examenes", _examenes);
 BA.debugLineNum = 30;BA.debugLine="examenes.Initialize";
Debug.ShouldStop(536870912);
_examenes.runVoidMethod ("Initialize");
 BA.debugLineNum = 32;BA.debugLine="For i = 1 To 3";
Debug.ShouldStop(-2147483648);
{
final int step6 = 1;
final int limit6 = 3;
_i = 1 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 33;BA.debugLine="Dim ex As Map";
Debug.ShouldStop(1);
_ex = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("ex", _ex);
 BA.debugLineNum = 34;BA.debugLine="ex.Initialize";
Debug.ShouldStop(2);
_ex.runVoidMethod ("Initialize");
 BA.debugLineNum = 35;BA.debugLine="ex.Put(\"NombreDelProcedimiento\", \"Radiografía Tó";
Debug.ShouldStop(4);
_ex.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("NombreDelProcedimiento"))),(Object)((RemoteObject.concat(RemoteObject.createImmutable("Radiografía Tórax "),RemoteObject.createImmutable(_i)))));
 BA.debugLineNum = 36;BA.debugLine="ex.Put(\"RutaImagen\", \"imagen\" & i & \".jpg\")";
Debug.ShouldStop(8);
_ex.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("RutaImagen"))),(Object)((RemoteObject.concat(RemoteObject.createImmutable("imagen"),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg")))));
 BA.debugLineNum = 37;BA.debugLine="ex.Put(\"FechaRealizado\", \"15/06/2025\")";
Debug.ShouldStop(16);
_ex.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("FechaRealizado"))),(Object)((RemoteObject.createImmutable("15/06/2025"))));
 BA.debugLineNum = 38;BA.debugLine="ex.Put(\"Rut\", Main.UsuarioActivo.Rut)";
Debug.ShouldStop(32);
_ex.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Rut"))),(Object)((verexamenes.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ ))));
 BA.debugLineNum = 39;BA.debugLine="examenes.Add(ex)";
Debug.ShouldStop(64);
_examenes.runVoidMethod ("Add",(Object)((_ex.getObject())));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 42;BA.debugLine="Dim gen As JSONGenerator";
Debug.ShouldStop(512);
_gen = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("gen", _gen);
 BA.debugLineNum = 43;BA.debugLine="gen.Initialize2(examenes)";
Debug.ShouldStop(1024);
_gen.runVoidMethod ("Initialize2",(Object)(_examenes));
 BA.debugLineNum = 44;BA.debugLine="File.WriteString(ruta, archivo, gen.ToString)";
Debug.ShouldStop(2048);
verexamenes.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(_ruta),(Object)(_archivo),(Object)(_gen.runMethod(true,"ToString")));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createitemexamen(RemoteObject _examen) throws Exception{
try {
		Debug.PushSubsStack("CreateItemExamen (verexamenes) ","verexamenes",7,verexamenes.mostCurrent.activityBA,verexamenes.mostCurrent,77);
if (RapidSub.canDelegate("createitemexamen")) { return b4a.example.verexamenes.remoteMe.runUserSub(false, "verexamenes","createitemexamen", _examen);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _pan = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblproc = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblfecha = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _btnver = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("examen", _examen);
 BA.debugLineNum = 77;BA.debugLine="Sub CreateItemExamen(examen As Map) As Panel";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = verexamenes.mostCurrent._xui.runMethod(false,"CreatePanel",verexamenes.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 79;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, CLV_Examenes.AsView.";
Debug.ShouldStop(16384);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(verexamenes.mostCurrent._clv_examenes.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(verexamenes.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))));
 BA.debugLineNum = 80;BA.debugLine="p.LoadLayout(\"VistaExamen\") ' este es tu layout c";
Debug.ShouldStop(32768);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("VistaExamen")),verexamenes.mostCurrent.activityBA);
 BA.debugLineNum = 81;BA.debugLine="Dim PAn As Panel = p.GetView(0)";
Debug.ShouldStop(65536);
_pan = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_pan = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _p.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("PAn", _pan);Debug.locals.put("PAn", _pan);
 BA.debugLineNum = 82;BA.debugLine="Dim LblProc As Label = PAn.GetView(0) ' o usa Pan";
Debug.ShouldStop(131072);
_lblproc = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lblproc = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _pan.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("LblProc", _lblproc);Debug.locals.put("LblProc", _lblproc);
 BA.debugLineNum = 83;BA.debugLine="Dim LblFecha As Label = PAn.GetView(1)";
Debug.ShouldStop(262144);
_lblfecha = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lblfecha = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _pan.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 1))).getObject());Debug.locals.put("LblFecha", _lblfecha);Debug.locals.put("LblFecha", _lblfecha);
 BA.debugLineNum = 84;BA.debugLine="Dim BtnVer As Button = PAn.GetView(2)";
Debug.ShouldStop(524288);
_btnver = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btnver = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), _pan.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 2))).getObject());Debug.locals.put("BtnVer", _btnver);Debug.locals.put("BtnVer", _btnver);
 BA.debugLineNum = 86;BA.debugLine="LblProc.Text = examen.Get(\"NombreDelProcedimiento";
Debug.ShouldStop(2097152);
_lblproc.runMethod(true,"setText",BA.ObjectToCharSequence(_examen.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("NombreDelProcedimiento"))))));
 BA.debugLineNum = 87;BA.debugLine="LblFecha.Text = examen.Get(\"FechaRealizado\")";
Debug.ShouldStop(4194304);
_lblfecha.runMethod(true,"setText",BA.ObjectToCharSequence(_examen.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("FechaRealizado"))))));
 BA.debugLineNum = 89;BA.debugLine="BtnVer.Tag = examen.Get(\"RutaImagen\")";
Debug.ShouldStop(16777216);
_btnver.runMethod(false,"setTag",_examen.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("RutaImagen")))));
 BA.debugLineNum = 91;BA.debugLine="Return p";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _p.getObject());
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
 //BA.debugLineNum = 15;BA.debugLine="Private listaExamenes As List";
verexamenes.mostCurrent._listaexamenes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 16;BA.debugLine="Private ImageViewer As ImageView";
verexamenes.mostCurrent._imageviewer = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private CLV_Examenes As CustomListView";
verexamenes.mostCurrent._clv_examenes = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 18;BA.debugLine="Private Panel1 As Panel";
verexamenes.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
verexamenes.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 20;BA.debugLine="Private MainPanel As Panel";
verexamenes.mostCurrent._mainpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private PanelEXA As Panel";
verexamenes.mostCurrent._panelexa = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}