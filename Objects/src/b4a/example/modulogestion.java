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

public class modulogestion extends Activity implements B4AActivity{
	public static modulogestion mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.modulogestion");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (modulogestion).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.modulogestion");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.modulogestion", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (modulogestion) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (modulogestion) Resume **");
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
		return modulogestion.class;
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
            BA.LogInfo("** Activity (modulogestion) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (modulogestion) Pause event (activity is not paused). **");
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
            modulogestion mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (modulogestion) Resume **");
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
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4a.example3.customlistview _listacitas = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_cancelar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_editar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_fecha = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_medico = null;
public b4a.example3.customlistview _listadoctores = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_modificar = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.starter _starter = null;
public b4a.example.calendario _calendario = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Activity.LoadLayout(\"VistaGesionar\")";
mostCurrent._activity.LoadLayout("VistaGesionar",mostCurrent.activityBA);
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="MostrarAtenciones";
_mostraratenciones();
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="End Sub";
return "";
}
public static String  _mostraratenciones() throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mostraratenciones", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mostraratenciones", null));}
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _lista = null;
String _rutactual = "";
int _indicevisual = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _atencion = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub MostrarAtenciones";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="ListaDoctores.Clear";
mostCurrent._listadoctores._clear();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="If File.Exists(ruta, archivo) = False Then Return";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_archivo)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_archivo));
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="Dim lista As List = parser.NextArray";
_lista = new anywheresoftware.b4a.objects.collections.List();
_lista = _parser.NextArray();
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="Dim rutActual As String = Main.UsuarioActivo.Rut";
_rutactual = mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ ;
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="Dim indiceVisual As Int = 0";
_indicevisual = (int) (0);
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="For i = 0 To lista.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_lista.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="Dim atencion As Map = lista.Get(i)";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
_atencion = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_lista.Get(_i)));
RDebugUtils.currentLine=3670032;
 //BA.debugLineNum = 3670032;BA.debugLine="If atencion.Get(\"rut_paciente\") = rutActual Then";
if ((_atencion.Get((Object)("rut_paciente"))).equals((Object)(_rutactual))) { 
RDebugUtils.currentLine=3670033;
 //BA.debugLineNum = 3670033;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=3670034;
 //BA.debugLineNum = 3670034;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, ListaDoctores.AsVi";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._listadoctores._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
RDebugUtils.currentLine=3670035;
 //BA.debugLineNum = 3670035;BA.debugLine="p.LoadLayout(\"VistaMod\")";
_p.LoadLayout("VistaMod",mostCurrent.activityBA);
RDebugUtils.currentLine=3670037;
 //BA.debugLineNum = 3670037;BA.debugLine="Lbl_Medico.Text = atencion.Get(\"nombre_medico\")";
mostCurrent._lbl_medico.setText(BA.ObjectToCharSequence(_atencion.Get((Object)("nombre_medico"))));
RDebugUtils.currentLine=3670038;
 //BA.debugLineNum = 3670038;BA.debugLine="Lbl_Fecha.Text = atencion.Get(\"fecha_atencion\")";
mostCurrent._lbl_fecha.setText(BA.ObjectToCharSequence(_atencion.Get((Object)("fecha_atencion"))));
RDebugUtils.currentLine=3670041;
 //BA.debugLineNum = 3670041;BA.debugLine="Btn_Modificar.Tag = i";
mostCurrent._btn_modificar.setTag((Object)(_i));
RDebugUtils.currentLine=3670042;
 //BA.debugLineNum = 3670042;BA.debugLine="Btn_Cancelar.Tag = i";
mostCurrent._btn_cancelar.setTag((Object)(_i));
RDebugUtils.currentLine=3670044;
 //BA.debugLineNum = 3670044;BA.debugLine="ListaDoctores.Add(p, \"\")";
mostCurrent._listadoctores._add(_p,(Object)(""));
RDebugUtils.currentLine=3670045;
 //BA.debugLineNum = 3670045;BA.debugLine="indiceVisual = indiceVisual + 1";
_indicevisual = (int) (_indicevisual+1);
 };
 }
};
RDebugUtils.currentLine=3670048;
 //BA.debugLineNum = 3670048;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="modulogestion";
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public static String  _btn_cancelar_click() throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_cancelar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_cancelar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
int _indice = 0;
int _res = 0;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Btn_Cancelar_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Dim indice As Int = btn.Tag";
_indice = (int)(BA.ObjectToNumber(_btn.getTag()));
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="Dim res As Int = Msgbox2(\"¿Deseas cancelar esta c";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Deseas cancelar esta cita?"),BA.ObjectToCharSequence("Confirmar"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="If res = DialogResponse.POSITIVE Then";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="EliminarAtencion(indice)";
_eliminaratencion(_indice);
 };
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="End Sub";
return "";
}
public static String  _eliminaratencion(int _indice) throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "eliminaratencion", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "eliminaratencion", new Object[] {_indice}));}
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _lista = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _generador = null;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub EliminarAtencion(indice As Int)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_archivo));
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="Dim lista As List = parser.NextArray";
_lista = new anywheresoftware.b4a.objects.collections.List();
_lista = _parser.NextArray();
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="lista.RemoveAt(indice)";
_lista.RemoveAt(_indice);
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="Dim generador As JSONGenerator";
_generador = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="generador.Initialize2(lista)";
_generador.Initialize2(_lista);
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
anywheresoftware.b4a.keywords.Common.File.WriteString(_ruta,_archivo,_generador.ToString());
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="ToastMessageShow(\"Cita cancelada\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cita cancelada"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="MostrarAtenciones";
_mostraratenciones();
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="End Sub";
return "";
}
public static String  _btn_modificar_click() throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_modificar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_modificar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
int _indice = 0;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub Btn_Modificar_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim indice As Int = btn.Tag";
_indice = (int)(BA.ObjectToNumber(_btn.getTag()));
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="MostrarDatePickerParaModificar(indice)";
_mostrardatepickerparamodificar(_indice);
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="End Sub";
return "";
}
public static String  _mostrardatepickerparamodificar(int _indice) throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mostrardatepickerparamodificar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mostrardatepickerparamodificar", new Object[] {_indice}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub MostrarDatePickerParaModificar(indice As Int)";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="jo.RunMethod(\"mostrarDatePickerModificar\", Array(";
_jo.RunMethod("mostrarDatePickerModificar",new Object[]{(Object)(_indice)});
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="End Sub";
return "";
}
public static String  _listacitas_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listacitas_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listacitas_itemclick", new Object[] {_index,_value}));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub ListaCitas_ItemClick (Index As Int, Va";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
public static String  _recibirfechamodificada(String _fecha,int _indice) throws Exception{
RDebugUtils.currentModule="modulogestion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "recibirfechamodificada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "recibirfechamodificada", new Object[] {_fecha,_indice}));}
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _lista = null;
anywheresoftware.b4a.objects.collections.Map _atencion = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _generador = null;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub RecibirFechaModificada(fecha As String, indice";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_archivo));
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Dim lista As List = parser.NextArray";
_lista = new anywheresoftware.b4a.objects.collections.List();
_lista = _parser.NextArray();
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="Dim atencion As Map = lista.Get(indice)";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
_atencion = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_lista.Get(_indice)));
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="atencion.Put(\"fecha_atencion\", fecha)";
_atencion.Put((Object)("fecha_atencion"),(Object)(_fecha));
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="Dim generador As JSONGenerator";
_generador = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="generador.Initialize2(lista)";
_generador.Initialize2(_lista);
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="File.WriteString(ruta, archivo, generador.ToStrin";
anywheresoftware.b4a.keywords.Common.File.WriteString(_ruta,_archivo,_generador.ToString());
RDebugUtils.currentLine=3604495;
 //BA.debugLineNum = 3604495;BA.debugLine="ToastMessageShow(\"Fecha modificada\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Fecha modificada"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3604496;
 //BA.debugLineNum = 3604496;BA.debugLine="MostrarAtenciones";
_mostraratenciones();
RDebugUtils.currentLine=3604497;
 //BA.debugLineNum = 3604497;BA.debugLine="End Sub";
return "";
}

public void mostrarDatePickerModificar(final int indice) {
    Calendar c = Calendar.getInstance();
    DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String fecha = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
            Object[] args = new Object[]{fecha, indice};
            processBA.raiseEventFromUI(this, "recibirfechamodificada", args);
        }
    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    dpd.show();
}
}