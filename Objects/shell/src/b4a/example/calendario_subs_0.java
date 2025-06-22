package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class calendario_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"VistaCalendario\")";
Debug.ShouldStop(16777216);
calendario.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("VistaCalendario")),calendario.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="listaAtenciones.Initialize";
Debug.ShouldStop(33554432);
calendario.mostCurrent._listaatenciones.runVoidMethod ("Initialize");
 BA.debugLineNum = 27;BA.debugLine="fechasConAtencion.Initialize";
Debug.ShouldStop(67108864);
calendario.mostCurrent._fechasconatencion.runVoidMethod ("Initialize");
 BA.debugLineNum = 28;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
Debug.ShouldStop(134217728);
calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 30;BA.debugLine="CargarFechasPaciente(Main.UsuarioActivo.Rut)";
Debug.ShouldStop(536870912);
_cargarfechaspaciente(calendario.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ ));
 BA.debugLineNum = 31;BA.debugLine="GenerarCalendarioMes(DateTime.GetYear(DateTime.No";
Debug.ShouldStop(1073741824);
_generarcalendariomes(calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,161);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 161;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 163;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,34);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","activity_resume");}
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _asignardiaapanel(RemoteObject _p,RemoteObject _dia,RemoteObject _mes,RemoteObject _año) throws Exception{
try {
		Debug.PushSubsStack("AsignarDiaAPanel (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,103);
if (RapidSub.canDelegate("asignardiaapanel")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","asignardiaapanel", _p, _dia, _mes, _año);}
RemoteObject _fechatexto = RemoteObject.createImmutable("");
RemoteObject _contenedor = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _mesaux = RemoteObject.createImmutable("");
Debug.locals.put("p", _p);
Debug.locals.put("dia", _dia);
Debug.locals.put("mes", _mes);
Debug.locals.put("año", _año);
 BA.debugLineNum = 103;BA.debugLine="Sub AsignarDiaAPanel(p As B4XView, dia As Int, mes";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="Dim fechaTexto As String = NumberFormat2(dia,";
Debug.ShouldStop(128);
_fechatexto = RemoteObject.concat(calendario.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _dia)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(calendario.mostCurrent.__c.getField(true,"False"))),RemoteObject.createImmutable("/"),calendario.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _mes)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(calendario.mostCurrent.__c.getField(true,"False"))),RemoteObject.createImmutable("/"),_año);Debug.locals.put("fechaTexto", _fechatexto);Debug.locals.put("fechaTexto", _fechatexto);
 BA.debugLineNum = 106;BA.debugLine="Dim contenedor As Panel = p.GetView(0)";
Debug.ShouldStop(512);
_contenedor = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_contenedor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _p.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("contenedor", _contenedor);Debug.locals.put("contenedor", _contenedor);
 BA.debugLineNum = 107;BA.debugLine="Dim lbl As Label = contenedor.GetView(0)' Ajusta";
Debug.ShouldStop(1024);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _contenedor.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("lbl", _lbl);Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 108;BA.debugLine="lbl.Text = dia";
Debug.ShouldStop(2048);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_dia));
 BA.debugLineNum = 110;BA.debugLine="If fechasConAtencion.IndexOf(fechaTexto) > -1";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean(">",calendario.mostCurrent._fechasconatencion.runMethod(true,"IndexOf",(Object)((_fechatexto))),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 111;BA.debugLine="lbl.TextColor = Colors.Red";
Debug.ShouldStop(16384);
_lbl.runMethod(true,"setTextColor",calendario.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 }else {
 BA.debugLineNum = 113;BA.debugLine="lbl.TextColor = Colors.Black";
Debug.ShouldStop(65536);
_lbl.runMethod(true,"setTextColor",calendario.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 };
 BA.debugLineNum = 115;BA.debugLine="Dim MESAUX As String";
Debug.ShouldStop(262144);
_mesaux = RemoteObject.createImmutable("");Debug.locals.put("MESAUX", _mesaux);
 BA.debugLineNum = 116;BA.debugLine="If(mes < 10) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",_mes,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 117;BA.debugLine="MESAUX = $\"0${mes}\"$";
Debug.ShouldStop(1048576);
_mesaux = (RemoteObject.concat(RemoteObject.createImmutable("0"),calendario.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_mes))),RemoteObject.createImmutable("")));Debug.locals.put("MESAUX", _mesaux);
 }else {
 BA.debugLineNum = 119;BA.debugLine="MESAUX = mes";
Debug.ShouldStop(4194304);
_mesaux = BA.NumberToString(_mes);Debug.locals.put("MESAUX", _mesaux);
 };
 BA.debugLineNum = 121;BA.debugLine="contenedor.Tag= $\"${dia}/${MESAUX}/${año}\"$";
Debug.ShouldStop(16777216);
_contenedor.runMethod(false,"setTag",((RemoteObject.concat(RemoteObject.createImmutable(""),calendario.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_dia))),RemoteObject.createImmutable("/"),calendario.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_mesaux))),RemoteObject.createImmutable("/"),calendario.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_año))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cargarfechaspaciente(RemoteObject _rut) throws Exception{
try {
		Debug.PushSubsStack("CargarFechasPaciente (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,87);
if (RapidSub.canDelegate("cargarfechaspaciente")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","cargarfechaspaciente", _rut);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _archivo = RemoteObject.createImmutable("");
RemoteObject _atencion = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("rut", _rut);
 BA.debugLineNum = 87;BA.debugLine="Sub CargarFechasPaciente(rut As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8388608);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 89;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
Debug.ShouldStop(16777216);
_archivo = BA.ObjectToString("atenciones.json");Debug.locals.put("archivo", _archivo);Debug.locals.put("archivo", _archivo);
 BA.debugLineNum = 90;BA.debugLine="If File.Exists(File.DirInternal, archivo) = False";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",calendario.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(calendario.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_archivo)),calendario.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 92;BA.debugLine="parser.Initialize(File.ReadString(File.DirInterna";
Debug.ShouldStop(134217728);
_parser.runVoidMethod ("Initialize",(Object)(calendario.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(calendario.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_archivo))));
 BA.debugLineNum = 93;BA.debugLine="listaAtenciones = parser.NextArray";
Debug.ShouldStop(268435456);
calendario.mostCurrent._listaatenciones = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 94;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
Debug.ShouldStop(536870912);
calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 96;BA.debugLine="For Each atencion As Map In listaAtenciones";
Debug.ShouldStop(-2147483648);
_atencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group7 = calendario.mostCurrent._listaatenciones;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_atencion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group7.runMethod(false,"Get",index7));Debug.locals.put("atencion", _atencion);
Debug.locals.put("atencion", _atencion);
 BA.debugLineNum = 97;BA.debugLine="If atencion.Get(\"rut_paciente\") = rut Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rut_paciente")))),(_rut))) { 
 BA.debugLineNum = 98;BA.debugLine="fechasConAtencion.Add(atencion.Get(\"fecha_atenc";
Debug.ShouldStop(2);
calendario.mostCurrent._fechasconatencion.runVoidMethod ("Add",(Object)(_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha_atencion"))))));
 };
 }
}Debug.locals.put("atencion", _atencion);
;
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _crearfilacalendario() throws Exception{
try {
		Debug.PushSubsStack("CrearFilaCalendario (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,74);
if (RapidSub.canDelegate("crearfilacalendario")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","crearfilacalendario");}
RemoteObject _fila = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
int _i = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
 BA.debugLineNum = 74;BA.debugLine="Sub CrearFilaCalendario As Panel";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Dim fila As Panel";
Debug.ShouldStop(1024);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 76;BA.debugLine="fila.Initialize(\"\")";
Debug.ShouldStop(2048);
_fila.runVoidMethod ("Initialize",calendario.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 77;BA.debugLine="fila.SetLayout(0, 0, 100%x, 50dip)";
Debug.ShouldStop(4096);
_fila.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(calendario.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calendario.mostCurrent.activityBA)),(Object)(calendario.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 79;BA.debugLine="For i = 0 To 6";
Debug.ShouldStop(16384);
{
final int step4 = 1;
final int limit4 = 6;
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 80;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(32768);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = calendario.mostCurrent._xui.runMethod(false,"CreatePanel",calendario.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 81;BA.debugLine="p.LoadLayout(\"item_dia\")";
Debug.ShouldStop(65536);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_dia")),calendario.mostCurrent.activityBA);
 BA.debugLineNum = 82;BA.debugLine="fila.AddView(p, i * (100%x / 7), 0, 100%x / 7, 5";
Debug.ShouldStop(131072);
_fila.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {calendario.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calendario.mostCurrent.activityBA),RemoteObject.createImmutable(7)}, "/",0, 0))}, "*",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {calendario.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calendario.mostCurrent.activityBA),RemoteObject.createImmutable(7)}, "/",0, 0))),(Object)(calendario.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 84;BA.debugLine="Return fila";
Debug.ShouldStop(524288);
if (true) return _fila;
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _crearfiladiassemana() throws Exception{
try {
		Debug.PushSubsStack("CrearFilaDiasSemana (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,142);
if (RapidSub.canDelegate("crearfiladiassemana")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","crearfiladiassemana");}
RemoteObject _fila = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _nombresdias = null;
int _i = 0;
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 142;BA.debugLine="Sub CrearFilaDiasSemana As Panel";
Debug.ShouldStop(8192);
 BA.debugLineNum = 143;BA.debugLine="Dim fila As Panel";
Debug.ShouldStop(16384);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 144;BA.debugLine="fila.Initialize(\"\")";
Debug.ShouldStop(32768);
_fila.runVoidMethod ("Initialize",calendario.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 145;BA.debugLine="fila.SetLayout(0, 0, 100%x, 40dip)";
Debug.ShouldStop(65536);
_fila.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(calendario.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calendario.mostCurrent.activityBA)),(Object)(calendario.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 147;BA.debugLine="Dim nombresDias() As String = Array As String(\"L\"";
Debug.ShouldStop(262144);
_nombresdias = RemoteObject.createNewArray("String",new int[] {7},new Object[] {BA.ObjectToString("L"),BA.ObjectToString("M"),BA.ObjectToString("M"),BA.ObjectToString("J"),BA.ObjectToString("V"),BA.ObjectToString("S"),RemoteObject.createImmutable("D")});Debug.locals.put("nombresDias", _nombresdias);Debug.locals.put("nombresDias", _nombresdias);
 BA.debugLineNum = 149;BA.debugLine="For i = 0 To 6";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = 6;
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 150;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(2097152);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 151;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(4194304);
_lbl.runVoidMethod ("Initialize",calendario.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 152;BA.debugLine="lbl.Text = nombresDias(i)";
Debug.ShouldStop(8388608);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_nombresdias.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 153;BA.debugLine="lbl.Gravity = Gravity.CENTER";
Debug.ShouldStop(16777216);
_lbl.runMethod(true,"setGravity",calendario.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 154;BA.debugLine="lbl.TextSize = 16";
Debug.ShouldStop(33554432);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 155;BA.debugLine="fila.AddView(lbl, i * (100%x / 7), 0, 100%x / 7,";
Debug.ShouldStop(67108864);
_fila.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {calendario.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calendario.mostCurrent.activityBA),RemoteObject.createImmutable(7)}, "/",0, 0))}, "*",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {calendario.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calendario.mostCurrent.activityBA),RemoteObject.createImmutable(7)}, "/",0, 0))),(Object)(calendario.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 158;BA.debugLine="Return fila";
Debug.ShouldStop(536870912);
if (true) return _fila;
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generarcalendariomes(RemoteObject _año,RemoteObject _mes) throws Exception{
try {
		Debug.PushSubsStack("GenerarCalendarioMes (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,37);
if (RapidSub.canDelegate("generarcalendariomes")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","generarcalendariomes", _año, _mes);}
RemoteObject _diasmes = RemoteObject.createImmutable(0);
RemoteObject _primerdiasemana = RemoteObject.createImmutable(0);
RemoteObject _offset = RemoteObject.createImmutable(0);
RemoteObject _diasenfila = RemoteObject.createImmutable(0);
RemoteObject _fila = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
int _i = 0;
int _dia = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("año", _año);
Debug.locals.put("mes", _mes);
 BA.debugLineNum = 37;BA.debugLine="Sub GenerarCalendarioMes(año As Int, mes As Int)";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="CLV_Calendario.Clear";
Debug.ShouldStop(32);
calendario.mostCurrent._clv_calendario.runVoidMethod ("_clear");
 BA.debugLineNum = 39;BA.debugLine="CLV_Calendario.Add(CrearFilaDiasSemana, \"\")";
Debug.ShouldStop(64);
calendario.mostCurrent._clv_calendario.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _crearfiladiassemana().getObject()),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 41;BA.debugLine="Dim diasMes As Int = DateUtils.NumberOfDaysInMont";
Debug.ShouldStop(256);
_diasmes = calendario.mostCurrent._dateutils.runMethod(true,"_numberofdaysinmonth",calendario.mostCurrent.activityBA,(Object)(_mes),(Object)(_año));Debug.locals.put("diasMes", _diasmes);Debug.locals.put("diasMes", _diasmes);
 BA.debugLineNum = 42;BA.debugLine="Dim primerDiaSemana As Int = DateTime.GetDayOfWee";
Debug.ShouldStop(512);
_primerdiasemana = calendario.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(calendario.mostCurrent._dateutils.runMethod(true,"_setdate",calendario.mostCurrent.activityBA,(Object)(_año),(Object)(_mes),(Object)(BA.numberCast(int.class, 1)))));Debug.locals.put("primerDiaSemana", _primerdiasemana);Debug.locals.put("primerDiaSemana", _primerdiasemana);
 BA.debugLineNum = 45;BA.debugLine="Dim offset As Int = primerDiaSemana - 2";
Debug.ShouldStop(4096);
_offset = RemoteObject.solve(new RemoteObject[] {_primerdiasemana,RemoteObject.createImmutable(2)}, "-",1, 1);Debug.locals.put("offset", _offset);Debug.locals.put("offset", _offset);
 BA.debugLineNum = 46;BA.debugLine="If offset < 0 Then offset = 6";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("<",_offset,BA.numberCast(double.class, 0))) { 
_offset = BA.numberCast(int.class, 6);Debug.locals.put("offset", _offset);};
 BA.debugLineNum = 48;BA.debugLine="Dim diasEnFila As Int = 0";
Debug.ShouldStop(32768);
_diasenfila = BA.numberCast(int.class, 0);Debug.locals.put("diasEnFila", _diasenfila);Debug.locals.put("diasEnFila", _diasenfila);
 BA.debugLineNum = 49;BA.debugLine="Dim fila As Panel = CrearFilaCalendario";
Debug.ShouldStop(65536);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_fila = _crearfilacalendario();Debug.locals.put("fila", _fila);Debug.locals.put("fila", _fila);
 BA.debugLineNum = 52;BA.debugLine="For i = 0 To offset - 1";
Debug.ShouldStop(524288);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_offset,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="fila.GetView(i).Visible = False";
Debug.ShouldStop(1048576);
_fila.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"setVisible",calendario.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 54;BA.debugLine="diasEnFila = diasEnFila + 1";
Debug.ShouldStop(2097152);
_diasenfila = RemoteObject.solve(new RemoteObject[] {_diasenfila,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("diasEnFila", _diasenfila);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 58;BA.debugLine="For dia = 1 To diasMes";
Debug.ShouldStop(33554432);
{
final int step13 = 1;
final int limit13 = _diasmes.<Integer>get().intValue();
_dia = 1 ;
for (;(step13 > 0 && _dia <= limit13) || (step13 < 0 && _dia >= limit13) ;_dia = ((int)(0 + _dia + step13))  ) {
Debug.locals.put("dia", _dia);
 BA.debugLineNum = 59;BA.debugLine="If diasEnFila = 7 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_diasenfila,BA.numberCast(double.class, 7))) { 
 BA.debugLineNum = 60;BA.debugLine="CLV_Calendario.Add(fila, \"\")";
Debug.ShouldStop(134217728);
calendario.mostCurrent._clv_calendario.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _fila.getObject()),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 61;BA.debugLine="fila = CrearFilaCalendario";
Debug.ShouldStop(268435456);
_fila = _crearfilacalendario();Debug.locals.put("fila", _fila);
 BA.debugLineNum = 62;BA.debugLine="diasEnFila = 0";
Debug.ShouldStop(536870912);
_diasenfila = BA.numberCast(int.class, 0);Debug.locals.put("diasEnFila", _diasenfila);
 };
 BA.debugLineNum = 65;BA.debugLine="Dim p As B4XView = fila.GetView(diasEnFila)";
Debug.ShouldStop(1);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _fila.runMethod(false,"GetView",(Object)(_diasenfila)).getObject());Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 66;BA.debugLine="AsignarDiaAPanel(p, dia, mes, año)";
Debug.ShouldStop(2);
_asignardiaapanel(_p,BA.numberCast(int.class, _dia),_mes,_año);
 BA.debugLineNum = 68;BA.debugLine="diasEnFila = diasEnFila + 1";
Debug.ShouldStop(8);
_diasenfila = RemoteObject.solve(new RemoteObject[] {_diasenfila,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("diasEnFila", _diasenfila);
 }
}Debug.locals.put("dia", _dia);
;
 BA.debugLineNum = 71;BA.debugLine="CLV_Calendario.Add(fila, \"\")";
Debug.ShouldStop(64);
calendario.mostCurrent._clv_calendario.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _fila.getObject()),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
 //BA.debugLineNum = 15;BA.debugLine="Private listaAtenciones As List";
calendario.mostCurrent._listaatenciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 16;BA.debugLine="Private fechasConAtencion As List";
calendario.mostCurrent._fechasconatencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 17;BA.debugLine="Private CLV_Calendario As CustomListView";
calendario.mostCurrent._clv_calendario = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
calendario.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Private Lbl_dia As Label";
calendario.mostCurrent._lbl_dia = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private PanelDia As Panel";
calendario.mostCurrent._paneldia = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _paneldia_click() throws Exception{
try {
		Debug.PushSubsStack("PanelDia_Click (calendario) ","calendario",6,calendario.mostCurrent.activityBA,calendario.mostCurrent,125);
if (RapidSub.canDelegate("paneldia_click")) { return b4a.example.calendario.remoteMe.runUserSub(false, "calendario","paneldia_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _fecha = RemoteObject.createImmutable("");
RemoteObject _atencion = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _msg = RemoteObject.createImmutable("");
 BA.debugLineNum = 125;BA.debugLine="Sub PanelDia_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Dim btn As Panel = Sender";
Debug.ShouldStop(536870912);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), calendario.mostCurrent.__c.runMethod(false,"Sender",calendario.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 128;BA.debugLine="Dim fecha As String = btn.Tag";
Debug.ShouldStop(-2147483648);
_fecha = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("fecha", _fecha);Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 131;BA.debugLine="For Each atencion As Map In listaAtenciones";
Debug.ShouldStop(4);
_atencion = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group3 = calendario.mostCurrent._listaatenciones;
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_atencion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group3.runMethod(false,"Get",index3));Debug.locals.put("atencion", _atencion);
Debug.locals.put("atencion", _atencion);
 BA.debugLineNum = 132;BA.debugLine="If atencion.Get(\"rut_paciente\") = Main.UsuarioAc";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rut_paciente")))),(calendario.mostCurrent._main._usuarioactivo /*RemoteObject*/ .getField(true,"Rut" /*RemoteObject*/ ))) && RemoteObject.solveBoolean("=",_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha_atencion")))),(_fecha))) { 
 BA.debugLineNum = 133;BA.debugLine="Dim msg As String = \"Atención con: \" & atencion";
Debug.ShouldStop(16);
_msg = RemoteObject.concat(RemoteObject.createImmutable("Atención con: "),_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre_medico")))),calendario.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Especialidad: "),_atencion.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("especialidad")))),calendario.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Fecha: "),_fecha);Debug.locals.put("msg", _msg);Debug.locals.put("msg", _msg);
 BA.debugLineNum = 134;BA.debugLine="Msgbox(msg, \"Atención médica\")";
Debug.ShouldStop(32);
calendario.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(_msg)),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Atención médica"))),calendario.mostCurrent.activityBA);
 BA.debugLineNum = 135;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("atencion", _atencion);
;
 BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"No hay atención este día\", Fals";
Debug.ShouldStop(1024);
calendario.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No hay atención este día")),(Object)(calendario.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
}