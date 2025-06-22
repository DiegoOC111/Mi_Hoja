package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class calendario extends Activity implements B4AActivity{
	public static calendario mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.calendario");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (calendario).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.calendario");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.calendario", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (calendario) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (calendario) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return calendario.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (calendario) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (calendario) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            calendario mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (calendario) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.List _listaatenciones = null;
public anywheresoftware.b4a.objects.collections.List _fechasconatencion = null;
public b4a.example3.customlistview _clv_calendario = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_dia = null;
public anywheresoftware.b4a.objects.PanelWrapper _paneldia = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.starter _starter = null;
public b4a.example.verexamenes _verexamenes = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="Activity.LoadLayout(\"VistaCalendario\")";
mostCurrent._activity.LoadLayout("VistaCalendario",mostCurrent.activityBA);
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="listaAtenciones.Initialize";
mostCurrent._listaatenciones.Initialize();
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="fechasConAtencion.Initialize";
mostCurrent._fechasconatencion.Initialize();
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="CargarFechasPaciente(Main.UsuarioActivo.Rut)";
_cargarfechaspaciente(mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ );
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="GenerarCalendarioMes(DateTime.GetYear(DateTime.No";
_generarcalendariomes(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()),anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="End Sub";
return "";
}
public static String  _cargarfechaspaciente(String _rut) throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargarfechaspaciente", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargarfechaspaciente", new Object[] {_rut}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
String _archivo = "";
anywheresoftware.b4a.objects.collections.Map _atencion = null;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub CargarFechasPaciente(rut As String)";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="If File.Exists(File.DirInternal, archivo) = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_archivo)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="parser.Initialize(File.ReadString(File.DirInterna";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_archivo));
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="listaAtenciones = parser.NextArray";
mostCurrent._listaatenciones = _parser.NextArray();
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="For Each atencion As Map In listaAtenciones";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group7 = mostCurrent._listaatenciones;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_atencion = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group7.Get(index7)));
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="If atencion.Get(\"rut_paciente\") = rut Then";
if ((_atencion.Get((Object)("rut_paciente"))).equals((Object)(_rut))) { 
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="fechasConAtencion.Add(atencion.Get(\"fecha_atenc";
mostCurrent._fechasconatencion.Add(_atencion.Get((Object)("fecha_atencion")));
 };
 }
};
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="End Sub";
return "";
}
public static String  _generarcalendariomes(int _año,int _mes) throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "generarcalendariomes", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "generarcalendariomes", new Object[] {_año,_mes}));}
int _diasmes = 0;
int _primerdiasemana = 0;
int _offset = 0;
int _diasenfila = 0;
anywheresoftware.b4a.objects.PanelWrapper _fila = null;
int _i = 0;
int _dia = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub GenerarCalendarioMes(año As Int, mes As Int)";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="CLV_Calendario.Clear";
mostCurrent._clv_calendario._clear();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="CLV_Calendario.Add(CrearFilaDiasSemana, \"\")";
mostCurrent._clv_calendario._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_crearfiladiassemana().getObject())),(Object)(""));
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="Dim diasMes As Int = DateUtils.NumberOfDaysInMont";
_diasmes = mostCurrent._dateutils._numberofdaysinmonth(mostCurrent.activityBA,_mes,_año);
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="Dim primerDiaSemana As Int = DateTime.GetDayOfWee";
_primerdiasemana = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(mostCurrent._dateutils._setdate(mostCurrent.activityBA,_año,_mes,(int) (1)));
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="Dim offset As Int = primerDiaSemana - 2";
_offset = (int) (_primerdiasemana-2);
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="If offset < 0 Then offset = 6";
if (_offset<0) { 
_offset = (int) (6);};
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="Dim diasEnFila As Int = 0";
_diasenfila = (int) (0);
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="Dim fila As Panel = CrearFilaCalendario";
_fila = new anywheresoftware.b4a.objects.PanelWrapper();
_fila = _crearfilacalendario();
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="For i = 0 To offset - 1";
{
final int step9 = 1;
final int limit9 = (int) (_offset-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="fila.GetView(i).Visible = False";
_fila.GetView(_i).setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="diasEnFila = diasEnFila + 1";
_diasenfila = (int) (_diasenfila+1);
 }
};
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="For dia = 1 To diasMes";
{
final int step13 = 1;
final int limit13 = _diasmes;
_dia = (int) (1) ;
for (;_dia <= limit13 ;_dia = _dia + step13 ) {
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="If diasEnFila = 7 Then";
if (_diasenfila==7) { 
RDebugUtils.currentLine=4128791;
 //BA.debugLineNum = 4128791;BA.debugLine="CLV_Calendario.Add(fila, \"\")";
mostCurrent._clv_calendario._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_fila.getObject())),(Object)(""));
RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="fila = CrearFilaCalendario";
_fila = _crearfilacalendario();
RDebugUtils.currentLine=4128793;
 //BA.debugLineNum = 4128793;BA.debugLine="diasEnFila = 0";
_diasenfila = (int) (0);
 };
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="Dim p As B4XView = fila.GetView(diasEnFila)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_fila.GetView(_diasenfila).getObject()));
RDebugUtils.currentLine=4128797;
 //BA.debugLineNum = 4128797;BA.debugLine="AsignarDiaAPanel(p, dia, mes, año)";
_asignardiaapanel(_p,_dia,_mes,_año);
RDebugUtils.currentLine=4128799;
 //BA.debugLineNum = 4128799;BA.debugLine="diasEnFila = diasEnFila + 1";
_diasenfila = (int) (_diasenfila+1);
 }
};
RDebugUtils.currentLine=4128802;
 //BA.debugLineNum = 4128802;BA.debugLine="CLV_Calendario.Add(fila, \"\")";
mostCurrent._clv_calendario._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_fila.getObject())),(Object)(""));
RDebugUtils.currentLine=4128803;
 //BA.debugLineNum = 4128803;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="calendario";
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="End Sub";
return "";
}
public static String  _asignardiaapanel(anywheresoftware.b4a.objects.B4XViewWrapper _p,int _dia,int _mes,int _año) throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignardiaapanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "asignardiaapanel", new Object[] {_p,_dia,_mes,_año}));}
String _fechatexto = "";
anywheresoftware.b4a.objects.PanelWrapper _contenedor = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
String _mesaux = "";
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub AsignarDiaAPanel(p As B4XView, dia As Int, mes";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Dim fechaTexto As String = NumberFormat2(dia,";
_fechatexto = anywheresoftware.b4a.keywords.Common.NumberFormat2(_dia,(int) (2),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.False)+"/"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_mes,(int) (2),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.False)+"/"+BA.NumberToString(_año);
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Dim contenedor As Panel = p.GetView(0)";
_contenedor = new anywheresoftware.b4a.objects.PanelWrapper();
_contenedor = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Dim lbl As Label = contenedor.GetView(0)' Ajusta";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_contenedor.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="lbl.Text = dia";
_lbl.setText(BA.ObjectToCharSequence(_dia));
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="If fechasConAtencion.IndexOf(fechaTexto) > -1";
if (mostCurrent._fechasconatencion.IndexOf((Object)(_fechatexto))>-1) { 
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="lbl.TextColor = Colors.Red";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 }else {
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="lbl.TextColor = Colors.Black";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="Dim MESAUX As String";
_mesaux = "";
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="If(mes < 10) Then";
if ((_mes<10)) { 
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="MESAUX = $\"0${mes}\"$";
_mesaux = ("0"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_mes))+"");
 }else {
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="MESAUX = mes";
_mesaux = BA.NumberToString(_mes);
 };
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="contenedor.Tag= $\"${dia}/${MESAUX}/${año}\"$";
_contenedor.setTag((Object)((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_dia))+"/"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_mesaux))+"/"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_año))+"")));
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _crearfilacalendario() throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "crearfilacalendario", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "crearfilacalendario", null));}
anywheresoftware.b4a.objects.PanelWrapper _fila = null;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub CrearFilaCalendario As Panel";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Dim fila As Panel";
_fila = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="fila.Initialize(\"\")";
_fila.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="fila.SetLayout(0, 0, 100%x, 50dip)";
_fila.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="For i = 0 To 6";
{
final int step4 = 1;
final int limit4 = (int) (6);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="p.LoadLayout(\"item_dia\")";
_p.LoadLayout("item_dia",mostCurrent.activityBA);
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="fila.AddView(p, i * (100%x / 7), 0, 100%x / 7, 5";
_fila.AddView((android.view.View)(_p.getObject()),(int) (_i*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7)),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 }
};
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="Return fila";
if (true) return _fila;
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.PanelWrapper  _crearfiladiassemana() throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "crearfiladiassemana", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "crearfiladiassemana", null));}
anywheresoftware.b4a.objects.PanelWrapper _fila = null;
String[] _nombresdias = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub CrearFilaDiasSemana As Panel";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Dim fila As Panel";
_fila = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="fila.Initialize(\"\")";
_fila.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="fila.SetLayout(0, 0, 100%x, 40dip)";
_fila.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="Dim nombresDias() As String = Array As String(\"L\"";
_nombresdias = new String[]{"L","M","M","J","V","S","D"};
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="For i = 0 To 6";
{
final int step5 = 1;
final int limit5 = (int) (6);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="lbl.Text = nombresDias(i)";
_lbl.setText(BA.ObjectToCharSequence(_nombresdias[_i]));
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="lbl.Gravity = Gravity.CENTER";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="lbl.TextSize = 16";
_lbl.setTextSize((float) (16));
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="fila.AddView(lbl, i * (100%x / 7), 0, 100%x / 7,";
_fila.AddView((android.view.View)(_lbl.getObject()),(int) (_i*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7)),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 }
};
RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="Return fila";
if (true) return _fila;
RDebugUtils.currentLine=4456465;
 //BA.debugLineNum = 4456465;BA.debugLine="End Sub";
return null;
}
public static String  _paneldia_click() throws Exception{
RDebugUtils.currentModule="calendario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "paneldia_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "paneldia_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _btn = null;
String _fecha = "";
anywheresoftware.b4a.objects.collections.Map _atencion = null;
String _msg = "";
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub PanelDia_Click";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Dim btn As Panel = Sender";
_btn = new anywheresoftware.b4a.objects.PanelWrapper();
_btn = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="Dim fecha As String = btn.Tag";
_fecha = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="For Each atencion As Map In listaAtenciones";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._listaatenciones;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_atencion = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group3.Get(index3)));
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="If atencion.Get(\"rut_paciente\") = Main.UsuarioAc";
if ((_atencion.Get((Object)("rut_paciente"))).equals((Object)(mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ )) && (_atencion.Get((Object)("fecha_atencion"))).equals((Object)(_fecha))) { 
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="Dim msg As String = \"Atención con: \" & atencion";
_msg = "Atención con: "+BA.ObjectToString(_atencion.Get((Object)("nombre_medico")))+anywheresoftware.b4a.keywords.Common.CRLF+"Especialidad: "+BA.ObjectToString(_atencion.Get((Object)("especialidad")))+anywheresoftware.b4a.keywords.Common.CRLF+"Fecha: "+_fecha;
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="Msgbox(msg, \"Atención médica\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence("Atención médica"),mostCurrent.activityBA);
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="ToastMessageShow(\"No hay atención este día\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No hay atención este día"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="End Sub";
return "";
}
}