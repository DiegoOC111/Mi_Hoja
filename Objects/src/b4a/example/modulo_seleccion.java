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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.modulo_seleccion");
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
public b4a.example.calendario _calendario = null;
public b4a.example.verexamenes _verexamenes = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"VistaElegirHora\")";
mostCurrent._activity.LoadLayout("VistaElegirHora",mostCurrent.activityBA);
 //BA.debugLineNum = 27;BA.debugLine="CargarDoctores";
_cargardoctores();
 //BA.debugLineNum = 28;BA.debugLine="LlenarSpinner";
_llenarspinner();
 //BA.debugLineNum = 29;BA.debugLine="Spiner_especialidad.SelectedIndex = 0 ' Disparar";
mostCurrent._spiner_especialidad.setSelectedIndex((int) (0));
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _addclickeventtopanel(anywheresoftware.b4a.objects.B4XViewWrapper _p) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
String _eventname = "";
Object _pe = null;
 //BA.debugLineNum = 169;BA.debugLine="Sub AddClickEventToPanel(p As B4XView)";
 //BA.debugLineNum = 170;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
 //BA.debugLineNum = 171;BA.debugLine="jo.RunMethod(\"setClickable\", Array(True))";
_jo.RunMethod("setClickable",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
 //BA.debugLineNum = 172;BA.debugLine="Dim eventName As String = \"DoctorPanel\"";
_eventname = "DoctorPanel";
 //BA.debugLineNum = 173;BA.debugLine="Dim pe As Object = jo.CreateEvent(\"android.vie";
_pe = _jo.CreateEvent(processBA,"android.view.View.OnClickListener",_eventname,(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 174;BA.debugLine="jo.RunMethod(\"setOnClickListener\", Array(pe))";
_jo.RunMethod("setOnClickListener",new Object[]{_pe});
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _btn_elegirfecha_click() throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Private Sub Btn_elegirFecha_Click";
 //BA.debugLineNum = 78;BA.debugLine="ShowDatePickerDialog";
_showdatepickerdialog();
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _btn_guardaratencion_click() throws Exception{
String _rut = "";
anywheresoftware.b4a.objects.collections.Map _atencion = null;
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.List _listaatenciones = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _generador = null;
 //BA.debugLineNum = 109;BA.debugLine="Sub Btn_guardarAtencion_Click";
 //BA.debugLineNum = 110;BA.debugLine="If DoctorSeleccionado.IsInitialized = False Then";
if (mostCurrent._doctorseleccionado.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 111;BA.debugLine="ToastMessageShow(\"Selecciona un doctor.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Selecciona un doctor."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 112;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 114;BA.debugLine="If FechaSeleccionada = \"\" Then";
if ((mostCurrent._fechaseleccionada).equals("")) { 
 //BA.debugLineNum = 115;BA.debugLine="ToastMessageShow(\"Selecciona una fecha.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Selecciona una fecha."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 116;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 118;BA.debugLine="Dim Rut As String = Main.UsuarioActivo.Rut";
_rut = mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ ;
 //BA.debugLineNum = 119;BA.debugLine="Dim atencion As Map";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 120;BA.debugLine="atencion.Initialize";
_atencion.Initialize();
 //BA.debugLineNum = 121;BA.debugLine="atencion.Put(\"rut_paciente\", Rut)";
_atencion.Put((Object)("rut_paciente"),(Object)(_rut));
 //BA.debugLineNum = 122;BA.debugLine="atencion.Put(\"nombre_medico\", DoctorSeleccionado.";
_atencion.Put((Object)("nombre_medico"),mostCurrent._doctorseleccionado.Get((Object)("nombre_completo")));
 //BA.debugLineNum = 123;BA.debugLine="atencion.Put(\"especialidad\", DoctorSeleccionado.G";
_atencion.Put((Object)("especialidad"),mostCurrent._doctorseleccionado.Get((Object)("especialidad")));
 //BA.debugLineNum = 124;BA.debugLine="atencion.Put(\"fecha_atencion\", FechaSeleccionada)";
_atencion.Put((Object)("fecha_atencion"),(Object)(mostCurrent._fechaseleccionada));
 //BA.debugLineNum = 126;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 //BA.debugLineNum = 127;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
 //BA.debugLineNum = 129;BA.debugLine="Dim listaAtenciones As List";
_listaatenciones = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 130;BA.debugLine="If File.Exists(ruta, archivo) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_archivo)) { 
 //BA.debugLineNum = 131;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 132;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo)";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_archivo));
 //BA.debugLineNum = 133;BA.debugLine="listaAtenciones = parser.NextArray";
_listaatenciones = _parser.NextArray();
 }else {
 //BA.debugLineNum = 135;BA.debugLine="listaAtenciones.Initialize";
_listaatenciones.Initialize();
 };
 //BA.debugLineNum = 138;BA.debugLine="listaAtenciones.Add(atencion)";
_listaatenciones.Add((Object)(_atencion.getObject()));
 //BA.debugLineNum = 140;BA.debugLine="Dim generador As JSONGenerator";
_generador = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 141;BA.debugLine="generador.Initialize2(listaAtenciones)";
_generador.Initialize2(_listaatenciones);
 //BA.debugLineNum = 142;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
anywheresoftware.b4a.keywords.Common.File.WriteString(_ruta,_archivo,_generador.ToString());
 //BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(\"Atención guardada correctamente";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Atención guardada correctamente"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 144;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public static String  _cargardoctores() throws Exception{
String _ruta = "";
String _nombrearchivo = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
 //BA.debugLineNum = 32;BA.debugLine="Sub CargarDoctores";
 //BA.debugLineNum = 33;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 //BA.debugLineNum = 34;BA.debugLine="Dim nombreArchivo As String = \"doctores.json\"";
_nombrearchivo = "doctores.json";
 //BA.debugLineNum = 36;BA.debugLine="If File.Exists(ruta, nombreArchivo) = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_nombrearchivo)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 37;BA.debugLine="ToastMessageShow(\"Archivo de doctores no encontr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Archivo de doctores no encontrado."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 38;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 41;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 42;BA.debugLine="parser.Initialize(File.ReadString(ruta, nombreArc";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_nombrearchivo));
 //BA.debugLineNum = 44;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 45;BA.debugLine="doctoresList = root.Get(\"doctores\") ' List<Map>";
mostCurrent._doctoreslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("doctores"))));
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createdoctoritem(anywheresoftware.b4a.objects.collections.Map _doctor) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
String _ruta = "";
 //BA.debugLineNum = 146;BA.debugLine="Sub CreateDoctorItem(doctor As Map) As Panel";
 //BA.debugLineNum = 147;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 148;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsV";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._listadoctores._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)));
 //BA.debugLineNum = 149;BA.debugLine="p.LoadLayout(\"VistaListaDoctores\")";
_p.LoadLayout("VistaListaDoctores",mostCurrent.activityBA);
 //BA.debugLineNum = 152;BA.debugLine="Lbl_nombre.Text = doctor.Get(\"nombre_completo\"";
mostCurrent._lbl_nombre.setText(BA.ObjectToCharSequence(_doctor.Get((Object)("nombre_completo"))));
 //BA.debugLineNum = 153;BA.debugLine="Lbl_especialidad.Text = doctor.Get(\"especialid";
mostCurrent._lbl_especialidad.setText(BA.ObjectToCharSequence(_doctor.Get((Object)("especialidad"))));
 //BA.debugLineNum = 155;BA.debugLine="Dim ruta As String = doctor.Get(\"foto_perfil\")";
_ruta = BA.ObjectToString(_doctor.Get((Object)("foto_perfil")));
 //BA.debugLineNum = 156;BA.debugLine="If File.Exists(File.DirAssets, ruta) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ruta)) { 
 //BA.debugLineNum = 157;BA.debugLine="IMG_Doc.Bitmap = LoadBitmap(File.DirAssets";
mostCurrent._img_doc.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ruta).getObject()));
 }else {
 //BA.debugLineNum = 159;BA.debugLine="IMG_Doc.Bitmap = LoadBitmapSample(File.Dir";
mostCurrent._img_doc.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"default.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))).getObject()));
 };
 //BA.debugLineNum = 163;BA.debugLine="p.Tag = doctor";
_p.setTag((Object)(_doctor.getObject()));
 //BA.debugLineNum = 164;BA.debugLine="AddClickEventToPanel(p)";
_addclickeventtopanel(_p);
 //BA.debugLineNum = 166;BA.debugLine="Return p";
if (true) return (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.getObject()));
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return null;
}
public static Object  _doctorpanel_event(String _methodname,Object[] _args) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.PanelWrapper _panelclicked = null;
 //BA.debugLineNum = 177;BA.debugLine="Sub DoctorPanel_Event (MethodName As String, Args(";
 //BA.debugLineNum = 178;BA.debugLine="Dim v As View = Args(0)";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_args[(int) (0)]));
 //BA.debugLineNum = 179;BA.debugLine="Dim panelClicked As Panel = v";
_panelclicked = new anywheresoftware.b4a.objects.PanelWrapper();
_panelclicked = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_v.getObject()));
 //BA.debugLineNum = 180;BA.debugLine="DoctorSeleccionado = panelClicked.Tag";
mostCurrent._doctorseleccionado = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_panelclicked.getTag()));
 //BA.debugLineNum = 181;BA.debugLine="ToastMessageShow(\"Doctor seleccionado: \" & Doc";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Doctor seleccionado: "+BA.ObjectToString(mostCurrent._doctorseleccionado.Get((Object)("nombre_completo")))),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 182;BA.debugLine="Return Null";
if (true) return anywheresoftware.b4a.keywords.Common.Null;
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private ListaDoctores As CustomListView";
mostCurrent._listadoctores = new b4a.example3.customlistview();
 //BA.debugLineNum = 14;BA.debugLine="Private Spiner_especialidad As Spinner";
mostCurrent._spiner_especialidad = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 16;BA.debugLine="Private doctoresList As List";
mostCurrent._doctoreslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 17;BA.debugLine="Private Lbl_nombre As Label";
mostCurrent._lbl_nombre = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private Lbl_especialidad As Label";
mostCurrent._lbl_especialidad = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private IMG_Doc As ImageView";
mostCurrent._img_doc = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private DoctorSeleccionado As Map";
mostCurrent._doctorseleccionado = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 21;BA.debugLine="Dim FechaSeleccionada As String";
mostCurrent._fechaseleccionada = "";
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _llenarspinner() throws Exception{
anywheresoftware.b4a.objects.collections.Map _especialidadesset = null;
anywheresoftware.b4a.objects.collections.Map _doctor = null;
String _esp = "";
String _key = "";
 //BA.debugLineNum = 48;BA.debugLine="Sub LlenarSpinner";
 //BA.debugLineNum = 49;BA.debugLine="Dim especialidadesSet As Map";
_especialidadesset = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 50;BA.debugLine="especialidadesSet.Initialize";
_especialidadesset.Initialize();
 //BA.debugLineNum = 52;BA.debugLine="For Each doctor As Map In doctoresList";
_doctor = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._doctoreslist;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_doctor = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group3.Get(index3)));
 //BA.debugLineNum = 53;BA.debugLine="Dim esp As String = doctor.Get(\"especialidad\")";
_esp = BA.ObjectToString(_doctor.Get((Object)("especialidad")));
 //BA.debugLineNum = 54;BA.debugLine="especialidadesSet.Put(esp, \"\")";
_especialidadesset.Put((Object)(_esp),(Object)(""));
 }
};
 //BA.debugLineNum = 57;BA.debugLine="Spiner_especialidad.Clear";
mostCurrent._spiner_especialidad.Clear();
 //BA.debugLineNum = 58;BA.debugLine="For Each key As String In especialidadesSet.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _especialidadesset.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_key = BA.ObjectToString(group8.Get(index8));
 //BA.debugLineNum = 59;BA.debugLine="Spiner_especialidad.Add(key)";
mostCurrent._spiner_especialidad.Add(_key);
 }
};
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _mostrardoctoresporespecialidad(String _especialidad) throws Exception{
anywheresoftware.b4a.objects.collections.Map _doctor = null;
 //BA.debugLineNum = 67;BA.debugLine="Sub MostrarDoctoresPorEspecialidad(especialidad As";
 //BA.debugLineNum = 68;BA.debugLine="ListaDoctores.Clear";
mostCurrent._listadoctores._clear();
 //BA.debugLineNum = 70;BA.debugLine="For Each doctor As Map In doctoresList";
_doctor = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._doctoreslist;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_doctor = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group2.Get(index2)));
 //BA.debugLineNum = 71;BA.debugLine="If doctor.Get(\"especialidad\") = especialidad The";
if ((_doctor.Get((Object)("especialidad"))).equals((Object)(_especialidad))) { 
 //BA.debugLineNum = 72;BA.debugLine="ListaDoctores.Add(CreateDoctorItem(doctor), \"\")";
mostCurrent._listadoctores._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_createdoctoritem(_doctor).getObject())),(Object)(""));
 };
 }
};
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _recibirfecha(String _fecha) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub RecibirFecha(fecha As String)";
 //BA.debugLineNum = 86;BA.debugLine="FechaSeleccionada = fecha";
mostCurrent._fechaseleccionada = _fecha;
 //BA.debugLineNum = 87;BA.debugLine="Log(\"Fecha: \" & FechaSeleccionada)";
anywheresoftware.b4a.keywords.Common.LogImpl("02818050","Fecha: "+mostCurrent._fechaseleccionada,0);
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _showdatepickerdialog() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 80;BA.debugLine="Sub ShowDatePickerDialog";
 //BA.debugLineNum = 81;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 82;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 83;BA.debugLine="jo.RunMethod(\"showDatePicker\", Null)";
_jo.RunMethod("showDatePicker",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _spiner_especialidad_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Sub Spiner_especialidad_ItemClick (Position As Int";
 //BA.debugLineNum = 64;BA.debugLine="MostrarDoctoresPorEspecialidad(Value)";
_mostrardoctoresporespecialidad(BA.ObjectToString(_value));
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
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
