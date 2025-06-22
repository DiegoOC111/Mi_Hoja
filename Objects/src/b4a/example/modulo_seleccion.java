package b4a.example;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;

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

public class modulo_seleccion extends Activity implements B4AActivity{
	public static modulo_seleccion mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.modulo_seleccion");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (modulo_seleccion).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.modulo_seleccion");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.modulo_seleccion", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (modulo_seleccion) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (modulo_seleccion) Resume **");
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
		return modulo_seleccion.class;
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
            BA.LogInfo("** Activity (modulo_seleccion) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (modulo_seleccion) Pause event (activity is not paused). **");
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
            modulo_seleccion mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (modulo_seleccion) Resume **");
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
public b4a.example3.customlistview _listadoctores = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spiner_especialidad = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.collections.List _doctoreslist = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_nombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_especialidad = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _img_doc = null;
public anywheresoftware.b4a.objects.collections.Map _doctorseleccionado = null;
public static String _fechaseleccionada = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.starter _starter = null;
public b4a.example.calendario _calendario = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Activity.LoadLayout(\"VistaElegirHora\")";
mostCurrent._activity.LoadLayout("VistaElegirHora",mostCurrent.activityBA);
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="CargarDoctores";
_cargardoctores();
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="LlenarSpinner";
_llenarspinner();
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Spiner_especialidad.SelectedIndex = 0 ' Disparar";
mostCurrent._spiner_especialidad.setSelectedIndex((int) (0));
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="End Sub";
return "";
}
public static String  _cargardoctores() throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargardoctores", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargardoctores", null));}
String _ruta = "";
String _nombrearchivo = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub CargarDoctores";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim nombreArchivo As String = \"doctores.json\"";
_nombrearchivo = "doctores.json";
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="If File.Exists(ruta, nombreArchivo) = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_nombrearchivo)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="ToastMessageShow(\"Archivo de doctores no encontr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Archivo de doctores no encontrado."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="parser.Initialize(File.ReadString(ruta, nombreArc";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_nombrearchivo));
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="doctoresList = root.Get(\"doctores\") ' List<Map>";
mostCurrent._doctoreslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("doctores"))));
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="End Sub";
return "";
}
public static String  _llenarspinner() throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "llenarspinner", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "llenarspinner", null));}
anywheresoftware.b4a.objects.collections.Map _especialidadesset = null;
anywheresoftware.b4a.objects.collections.Map _doctor = null;
String _esp = "";
String _key = "";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub LlenarSpinner";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Dim especialidadesSet As Map";
_especialidadesset = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="especialidadesSet.Initialize";
_especialidadesset.Initialize();
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="For Each doctor As Map In doctoresList";
_doctor = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._doctoreslist;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_doctor = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group3.Get(index3)));
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="Dim esp As String = doctor.Get(\"especialidad\")";
_esp = BA.ObjectToString(_doctor.Get((Object)("especialidad")));
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="especialidadesSet.Put(esp, \"\")";
_especialidadesset.Put((Object)(_esp),(Object)(""));
 }
};
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="Spiner_especialidad.Clear";
mostCurrent._spiner_especialidad.Clear();
RDebugUtils.currentLine=2359306;
 //BA.debugLineNum = 2359306;BA.debugLine="For Each key As String In especialidadesSet.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _especialidadesset.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_key = BA.ObjectToString(group8.Get(index8));
RDebugUtils.currentLine=2359307;
 //BA.debugLineNum = 2359307;BA.debugLine="Spiner_especialidad.Add(key)";
mostCurrent._spiner_especialidad.Add(_key);
 }
};
RDebugUtils.currentLine=2359309;
 //BA.debugLineNum = 2359309;BA.debugLine="End Sub";
return "";
}
public static String  _addclickeventtopanel(anywheresoftware.b4a.objects.B4XViewWrapper _p) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addclickeventtopanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addclickeventtopanel", new Object[] {_p}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
String _eventname = "";
Object _pe = null;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub AddClickEventToPanel(p As B4XView)";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="jo.RunMethod(\"setClickable\", Array(True))";
_jo.RunMethod("setClickable",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Dim eventName As String = \"DoctorPanel\"";
_eventname = "DoctorPanel";
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Dim pe As Object = jo.CreateEvent(\"android.vie";
_pe = _jo.CreateEvent(processBA,"android.view.View.OnClickListener",_eventname,(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="jo.RunMethod(\"setOnClickListener\", Array(pe))";
_jo.RunMethod("setOnClickListener",new Object[]{_pe});
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="End Sub";
return "";
}
public static String  _btn_elegirfecha_click() throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_elegirfecha_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_elegirfecha_click", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Private Sub Btn_elegirFecha_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="ShowDatePickerDialog";
_showdatepickerdialog();
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="End Sub";
return "";
}
public static String  _showdatepickerdialog() throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showdatepickerdialog", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showdatepickerdialog", null));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub ShowDatePickerDialog";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="jo.RunMethod(\"showDatePicker\", Null)";
_jo.RunMethod("showDatePicker",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="End Sub";
return "";
}
public static String  _btn_guardaratencion_click() throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_guardaratencion_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_guardaratencion_click", null));}
String _rut = "";
anywheresoftware.b4a.objects.collections.Map _atencion = null;
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.List _listaatenciones = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _generador = null;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Btn_guardarAtencion_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="If DoctorSeleccionado.IsInitialized = False Then";
if (mostCurrent._doctorseleccionado.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="ToastMessageShow(\"Selecciona un doctor.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Selecciona un doctor."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="If FechaSeleccionada = \"\" Then";
if ((mostCurrent._fechaseleccionada).equals("")) { 
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="ToastMessageShow(\"Selecciona una fecha.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Selecciona una fecha."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="Dim Rut As String = Main.UsuarioActivo.Rut";
_rut = mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ ;
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="Dim atencion As Map";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="atencion.Initialize";
_atencion.Initialize();
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="atencion.Put(\"rut_paciente\", Rut)";
_atencion.Put((Object)("rut_paciente"),(Object)(_rut));
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="atencion.Put(\"nombre_medico\", DoctorSeleccionado.";
_atencion.Put((Object)("nombre_medico"),mostCurrent._doctorseleccionado.Get((Object)("nombre_completo")));
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="atencion.Put(\"especialidad\", DoctorSeleccionado.G";
_atencion.Put((Object)("especialidad"),mostCurrent._doctorseleccionado.Get((Object)("especialidad")));
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="atencion.Put(\"fecha_atencion\", FechaSeleccionada)";
_atencion.Put((Object)("fecha_atencion"),(Object)(mostCurrent._fechaseleccionada));
RDebugUtils.currentLine=2752529;
 //BA.debugLineNum = 2752529;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=2752530;
 //BA.debugLineNum = 2752530;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
RDebugUtils.currentLine=2752532;
 //BA.debugLineNum = 2752532;BA.debugLine="Dim listaAtenciones As List";
_listaatenciones = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="If File.Exists(ruta, archivo) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_archivo)) { 
RDebugUtils.currentLine=2752534;
 //BA.debugLineNum = 2752534;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2752535;
 //BA.debugLineNum = 2752535;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo)";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_archivo));
RDebugUtils.currentLine=2752536;
 //BA.debugLineNum = 2752536;BA.debugLine="listaAtenciones = parser.NextArray";
_listaatenciones = _parser.NextArray();
 }else {
RDebugUtils.currentLine=2752538;
 //BA.debugLineNum = 2752538;BA.debugLine="listaAtenciones.Initialize";
_listaatenciones.Initialize();
 };
RDebugUtils.currentLine=2752541;
 //BA.debugLineNum = 2752541;BA.debugLine="listaAtenciones.Add(atencion)";
_listaatenciones.Add((Object)(_atencion.getObject()));
RDebugUtils.currentLine=2752543;
 //BA.debugLineNum = 2752543;BA.debugLine="Dim generador As JSONGenerator";
_generador = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=2752544;
 //BA.debugLineNum = 2752544;BA.debugLine="generador.Initialize2(listaAtenciones)";
_generador.Initialize2(_listaatenciones);
RDebugUtils.currentLine=2752545;
 //BA.debugLineNum = 2752545;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
anywheresoftware.b4a.keywords.Common.File.WriteString(_ruta,_archivo,_generador.ToString());
RDebugUtils.currentLine=2752546;
 //BA.debugLineNum = 2752546;BA.debugLine="ToastMessageShow(\"Atención guardada correctamente";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Atención guardada correctamente"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2752547;
 //BA.debugLineNum = 2752547;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2752548;
 //BA.debugLineNum = 2752548;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createdoctoritem(anywheresoftware.b4a.objects.collections.Map _doctor) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createdoctoritem", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "createdoctoritem", new Object[] {_doctor}));}
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
String _ruta = "";
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub CreateDoctorItem(doctor As Map) As Panel";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsV";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._listadoctores._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)));
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="p.LoadLayout(\"VistaListaDoctores\")";
_p.LoadLayout("VistaListaDoctores",mostCurrent.activityBA);
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="Lbl_nombre.Text = doctor.Get(\"nombre_completo\"";
mostCurrent._lbl_nombre.setText(BA.ObjectToCharSequence(_doctor.Get((Object)("nombre_completo"))));
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="Lbl_especialidad.Text = doctor.Get(\"especialid";
mostCurrent._lbl_especialidad.setText(BA.ObjectToCharSequence(_doctor.Get((Object)("especialidad"))));
RDebugUtils.currentLine=2818057;
 //BA.debugLineNum = 2818057;BA.debugLine="Dim ruta As String = doctor.Get(\"foto_perfil\")";
_ruta = BA.ObjectToString(_doctor.Get((Object)("foto_perfil")));
RDebugUtils.currentLine=2818058;
 //BA.debugLineNum = 2818058;BA.debugLine="If File.Exists(File.DirAssets, ruta) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ruta)) { 
RDebugUtils.currentLine=2818059;
 //BA.debugLineNum = 2818059;BA.debugLine="IMG_Doc.Bitmap = LoadBitmap(File.DirAssets";
mostCurrent._img_doc.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ruta).getObject()));
 }else {
RDebugUtils.currentLine=2818061;
 //BA.debugLineNum = 2818061;BA.debugLine="IMG_Doc.Bitmap = LoadBitmapSample(File.Dir";
mostCurrent._img_doc.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"default.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))).getObject()));
 };
RDebugUtils.currentLine=2818065;
 //BA.debugLineNum = 2818065;BA.debugLine="p.Tag = doctor";
_p.setTag((Object)(_doctor.getObject()));
RDebugUtils.currentLine=2818066;
 //BA.debugLineNum = 2818066;BA.debugLine="AddClickEventToPanel(p)";
_addclickeventtopanel(_p);
RDebugUtils.currentLine=2818068;
 //BA.debugLineNum = 2818068;BA.debugLine="Return p";
if (true) return (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.getObject()));
RDebugUtils.currentLine=2818069;
 //BA.debugLineNum = 2818069;BA.debugLine="End Sub";
return null;
}
public static Object  _doctorpanel_event(String _methodname,Object[] _args) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "doctorpanel_event", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "doctorpanel_event", new Object[] {_methodname,_args}));}
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.PanelWrapper _panelclicked = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub DoctorPanel_Event (MethodName As String, Args(";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim v As View = Args(0)";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_args[(int) (0)]));
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim panelClicked As Panel = v";
_panelclicked = new anywheresoftware.b4a.objects.PanelWrapper();
_panelclicked = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="DoctorSeleccionado = panelClicked.Tag";
mostCurrent._doctorseleccionado = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_panelclicked.getTag()));
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="ToastMessageShow(\"Doctor seleccionado: \" & Doc";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Doctor seleccionado: "+BA.ObjectToString(mostCurrent._doctorseleccionado.Get((Object)("nombre_completo")))),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="Return Null";
if (true) return anywheresoftware.b4a.keywords.Common.Null;
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return null;
}
public static String  _mostrardoctoresporespecialidad(String _especialidad) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mostrardoctoresporespecialidad", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mostrardoctoresporespecialidad", new Object[] {_especialidad}));}
anywheresoftware.b4a.objects.collections.Map _doctor = null;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub MostrarDoctoresPorEspecialidad(especialidad As";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="ListaDoctores.Clear";
mostCurrent._listadoctores._clear();
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="For Each doctor As Map In doctoresList";
_doctor = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._doctoreslist;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_doctor = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group2.Get(index2)));
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="If doctor.Get(\"especialidad\") = especialidad The";
if ((_doctor.Get((Object)("especialidad"))).equals((Object)(_especialidad))) { 
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="ListaDoctores.Add(CreateDoctorItem(doctor), \"\")";
mostCurrent._listadoctores._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_createdoctoritem(_doctor).getObject())),(Object)(""));
 };
 }
};
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="End Sub";
return "";
}
public static String  _recibirfecha(String _fecha) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "recibirfecha", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "recibirfecha", new Object[] {_fecha}));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub RecibirFecha(fecha As String)";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="FechaSeleccionada = fecha";
mostCurrent._fechaseleccionada = _fecha;
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Log(\"Fecha: \" & FechaSeleccionada)";
anywheresoftware.b4a.keywords.Common.LogImpl("22686978","Fecha: "+mostCurrent._fechaseleccionada,0);
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="End Sub";
return "";
}
public static String  _spiner_especialidad_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="modulo_seleccion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spiner_especialidad_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "spiner_especialidad_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub Spiner_especialidad_ItemClick (Position As Int";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="MostrarDoctoresPorEspecialidad(Value)";
_mostrardoctoresporespecialidad(BA.ObjectToString(_value));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}


public void showDatePicker() {
    Calendar c = Calendar.getInstance();
    DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String fecha = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
            processBA.raiseEventFromUI(this, "recibirfecha", fecha);
        }
    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    dpd.show();
}
}