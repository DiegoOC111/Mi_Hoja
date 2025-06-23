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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.calendario");
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
 //BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"VistaCalendario\")";
mostCurrent._activity.LoadLayout("VistaCalendario",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="listaAtenciones.Initialize";
mostCurrent._listaatenciones.Initialize();
 //BA.debugLineNum = 27;BA.debugLine="fechasConAtencion.Initialize";
mostCurrent._fechasconatencion.Initialize();
 //BA.debugLineNum = 28;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
 //BA.debugLineNum = 30;BA.debugLine="CargarFechasPaciente(Main.UsuarioActivo.Rut)";
_cargarfechaspaciente(mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ );
 //BA.debugLineNum = 31;BA.debugLine="GenerarCalendarioMes(DateTime.GetYear(DateTime.No";
_generarcalendariomes(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()),anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _asignardiaapanel(anywheresoftware.b4a.objects.B4XViewWrapper _p,int _dia,int _mes,int _año) throws Exception{
String _fechatexto = "";
anywheresoftware.b4a.objects.PanelWrapper _contenedor = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
String _mesaux = "";
 //BA.debugLineNum = 103;BA.debugLine="Sub AsignarDiaAPanel(p As B4XView, dia As Int, mes";
 //BA.debugLineNum = 104;BA.debugLine="Dim fechaTexto As String = NumberFormat2(dia,";
_fechatexto = anywheresoftware.b4a.keywords.Common.NumberFormat2(_dia,(int) (2),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.False)+"/"+anywheresoftware.b4a.keywords.Common.NumberFormat2(_mes,(int) (2),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.False)+"/"+BA.NumberToString(_año);
 //BA.debugLineNum = 106;BA.debugLine="Dim contenedor As Panel = p.GetView(0)";
_contenedor = new anywheresoftware.b4a.objects.PanelWrapper();
_contenedor = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.GetView((int) (0)).getObject()));
 //BA.debugLineNum = 107;BA.debugLine="Dim lbl As Label = contenedor.GetView(0)' Ajusta";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_contenedor.GetView((int) (0)).getObject()));
 //BA.debugLineNum = 108;BA.debugLine="lbl.Text = dia";
_lbl.setText(BA.ObjectToCharSequence(_dia));
 //BA.debugLineNum = 110;BA.debugLine="If fechasConAtencion.IndexOf(fechaTexto) > -1";
if (mostCurrent._fechasconatencion.IndexOf((Object)(_fechatexto))>-1) { 
 //BA.debugLineNum = 111;BA.debugLine="lbl.TextColor = Colors.Red";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 }else {
 //BA.debugLineNum = 113;BA.debugLine="lbl.TextColor = Colors.Black";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
 //BA.debugLineNum = 115;BA.debugLine="Dim MESAUX As String";
_mesaux = "";
 //BA.debugLineNum = 116;BA.debugLine="If(mes < 10) Then";
if ((_mes<10)) { 
 //BA.debugLineNum = 117;BA.debugLine="MESAUX = $\"0${mes}\"$";
_mesaux = ("0"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_mes))+"");
 }else {
 //BA.debugLineNum = 119;BA.debugLine="MESAUX = mes";
_mesaux = BA.NumberToString(_mes);
 };
 //BA.debugLineNum = 121;BA.debugLine="contenedor.Tag= $\"${dia}/${MESAUX}/${año}\"$";
_contenedor.setTag((Object)((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_dia))+"/"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_mesaux))+"/"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_año))+"")));
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _cargarfechaspaciente(String _rut) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
String _archivo = "";
anywheresoftware.b4a.objects.collections.Map _atencion = null;
 //BA.debugLineNum = 87;BA.debugLine="Sub CargarFechasPaciente(rut As String)";
 //BA.debugLineNum = 88;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 89;BA.debugLine="Dim archivo As String = \"atenciones.json\"";
_archivo = "atenciones.json";
 //BA.debugLineNum = 90;BA.debugLine="If File.Exists(File.DirInternal, archivo) = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_archivo)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 92;BA.debugLine="parser.Initialize(File.ReadString(File.DirInterna";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_archivo));
 //BA.debugLineNum = 93;BA.debugLine="listaAtenciones = parser.NextArray";
mostCurrent._listaatenciones = _parser.NextArray();
 //BA.debugLineNum = 94;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
 //BA.debugLineNum = 96;BA.debugLine="For Each atencion As Map In listaAtenciones";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group7 = mostCurrent._listaatenciones;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_atencion = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group7.Get(index7)));
 //BA.debugLineNum = 97;BA.debugLine="If atencion.Get(\"rut_paciente\") = rut Then";
if ((_atencion.Get((Object)("rut_paciente"))).equals((Object)(_rut))) { 
 //BA.debugLineNum = 98;BA.debugLine="fechasConAtencion.Add(atencion.Get(\"fecha_atenc";
mostCurrent._fechasconatencion.Add(_atencion.Get((Object)("fecha_atencion")));
 };
 }
};
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _crearfilacalendario() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _fila = null;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 74;BA.debugLine="Sub CrearFilaCalendario As Panel";
 //BA.debugLineNum = 75;BA.debugLine="Dim fila As Panel";
_fila = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 76;BA.debugLine="fila.Initialize(\"\")";
_fila.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 77;BA.debugLine="fila.SetLayout(0, 0, 100%x, 50dip)";
_fila.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 79;BA.debugLine="For i = 0 To 6";
{
final int step4 = 1;
final int limit4 = (int) (6);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 80;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._xui.CreatePanel(processBA,"");
 //BA.debugLineNum = 81;BA.debugLine="p.LoadLayout(\"item_dia\")";
_p.LoadLayout("item_dia",mostCurrent.activityBA);
 //BA.debugLineNum = 82;BA.debugLine="fila.AddView(p, i * (100%x / 7), 0, 100%x / 7, 5";
_fila.AddView((android.view.View)(_p.getObject()),(int) (_i*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7)),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 }
};
 //BA.debugLineNum = 84;BA.debugLine="Return fila";
if (true) return _fila;
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.PanelWrapper  _crearfiladiassemana() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _fila = null;
String[] _nombresdias = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 142;BA.debugLine="Sub CrearFilaDiasSemana As Panel";
 //BA.debugLineNum = 143;BA.debugLine="Dim fila As Panel";
_fila = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 144;BA.debugLine="fila.Initialize(\"\")";
_fila.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 145;BA.debugLine="fila.SetLayout(0, 0, 100%x, 40dip)";
_fila.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 147;BA.debugLine="Dim nombresDias() As String = Array As String(\"L\"";
_nombresdias = new String[]{"L","M","M","J","V","S","D"};
 //BA.debugLineNum = 149;BA.debugLine="For i = 0 To 6";
{
final int step5 = 1;
final int limit5 = (int) (6);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 150;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 151;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 152;BA.debugLine="lbl.Text = nombresDias(i)";
_lbl.setText(BA.ObjectToCharSequence(_nombresdias[_i]));
 //BA.debugLineNum = 153;BA.debugLine="lbl.Gravity = Gravity.CENTER";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 154;BA.debugLine="lbl.TextSize = 16";
_lbl.setTextSize((float) (16));
 //BA.debugLineNum = 155;BA.debugLine="fila.AddView(lbl, i * (100%x / 7), 0, 100%x / 7,";
_fila.AddView((android.view.View)(_lbl.getObject()),(int) (_i*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7)),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)7),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 }
};
 //BA.debugLineNum = 158;BA.debugLine="Return fila";
if (true) return _fila;
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return null;
}
public static String  _generarcalendariomes(int _año,int _mes) throws Exception{
int _diasmes = 0;
int _primerdiasemana = 0;
int _offset = 0;
int _diasenfila = 0;
anywheresoftware.b4a.objects.PanelWrapper _fila = null;
int _i = 0;
int _dia = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 37;BA.debugLine="Sub GenerarCalendarioMes(año As Int, mes As Int)";
 //BA.debugLineNum = 38;BA.debugLine="CLV_Calendario.Clear";
mostCurrent._clv_calendario._clear();
 //BA.debugLineNum = 39;BA.debugLine="CLV_Calendario.Add(CrearFilaDiasSemana, \"\")";
mostCurrent._clv_calendario._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_crearfiladiassemana().getObject())),(Object)(""));
 //BA.debugLineNum = 41;BA.debugLine="Dim diasMes As Int = DateUtils.NumberOfDaysInMont";
_diasmes = mostCurrent._dateutils._numberofdaysinmonth(mostCurrent.activityBA,_mes,_año);
 //BA.debugLineNum = 42;BA.debugLine="Dim primerDiaSemana As Int = DateTime.GetDayOfWee";
_primerdiasemana = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(mostCurrent._dateutils._setdate(mostCurrent.activityBA,_año,_mes,(int) (1)));
 //BA.debugLineNum = 45;BA.debugLine="Dim offset As Int = primerDiaSemana - 2";
_offset = (int) (_primerdiasemana-2);
 //BA.debugLineNum = 46;BA.debugLine="If offset < 0 Then offset = 6";
if (_offset<0) { 
_offset = (int) (6);};
 //BA.debugLineNum = 48;BA.debugLine="Dim diasEnFila As Int = 0";
_diasenfila = (int) (0);
 //BA.debugLineNum = 49;BA.debugLine="Dim fila As Panel = CrearFilaCalendario";
_fila = new anywheresoftware.b4a.objects.PanelWrapper();
_fila = _crearfilacalendario();
 //BA.debugLineNum = 52;BA.debugLine="For i = 0 To offset - 1";
{
final int step9 = 1;
final int limit9 = (int) (_offset-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 53;BA.debugLine="fila.GetView(i).Visible = False";
_fila.GetView(_i).setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 54;BA.debugLine="diasEnFila = diasEnFila + 1";
_diasenfila = (int) (_diasenfila+1);
 }
};
 //BA.debugLineNum = 58;BA.debugLine="For dia = 1 To diasMes";
{
final int step13 = 1;
final int limit13 = _diasmes;
_dia = (int) (1) ;
for (;_dia <= limit13 ;_dia = _dia + step13 ) {
 //BA.debugLineNum = 59;BA.debugLine="If diasEnFila = 7 Then";
if (_diasenfila==7) { 
 //BA.debugLineNum = 60;BA.debugLine="CLV_Calendario.Add(fila, \"\")";
mostCurrent._clv_calendario._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_fila.getObject())),(Object)(""));
 //BA.debugLineNum = 61;BA.debugLine="fila = CrearFilaCalendario";
_fila = _crearfilacalendario();
 //BA.debugLineNum = 62;BA.debugLine="diasEnFila = 0";
_diasenfila = (int) (0);
 };
 //BA.debugLineNum = 65;BA.debugLine="Dim p As B4XView = fila.GetView(diasEnFila)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_fila.GetView(_diasenfila).getObject()));
 //BA.debugLineNum = 66;BA.debugLine="AsignarDiaAPanel(p, dia, mes, año)";
_asignardiaapanel(_p,_dia,_mes,_año);
 //BA.debugLineNum = 68;BA.debugLine="diasEnFila = diasEnFila + 1";
_diasenfila = (int) (_diasenfila+1);
 }
};
 //BA.debugLineNum = 71;BA.debugLine="CLV_Calendario.Add(fila, \"\")";
mostCurrent._clv_calendario._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_fila.getObject())),(Object)(""));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private listaAtenciones As List";
mostCurrent._listaatenciones = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 16;BA.debugLine="Private fechasConAtencion As List";
mostCurrent._fechasconatencion = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 17;BA.debugLine="Private CLV_Calendario As CustomListView";
mostCurrent._clv_calendario = new b4a.example3.customlistview();
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
mostCurrent._xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="Private Lbl_dia As Label";
mostCurrent._lbl_dia = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private PanelDia As Panel";
mostCurrent._paneldia = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _paneldia_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _btn = null;
String _fecha = "";
anywheresoftware.b4a.objects.collections.Map _atencion = null;
String _msg = "";
 //BA.debugLineNum = 125;BA.debugLine="Sub PanelDia_Click";
 //BA.debugLineNum = 126;BA.debugLine="Dim btn As Panel = Sender";
_btn = new anywheresoftware.b4a.objects.PanelWrapper();
_btn = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 128;BA.debugLine="Dim fecha As String = btn.Tag";
_fecha = BA.ObjectToString(_btn.getTag());
 //BA.debugLineNum = 131;BA.debugLine="For Each atencion As Map In listaAtenciones";
_atencion = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._listaatenciones;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_atencion = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group3.Get(index3)));
 //BA.debugLineNum = 132;BA.debugLine="If atencion.Get(\"rut_paciente\") = Main.UsuarioAc";
if ((_atencion.Get((Object)("rut_paciente"))).equals((Object)(mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ )) && (_atencion.Get((Object)("fecha_atencion"))).equals((Object)(_fecha))) { 
 //BA.debugLineNum = 133;BA.debugLine="Dim msg As String = \"Atención con: \" & atencion";
_msg = "Atención con: "+BA.ObjectToString(_atencion.Get((Object)("nombre_medico")))+anywheresoftware.b4a.keywords.Common.CRLF+"Especialidad: "+BA.ObjectToString(_atencion.Get((Object)("especialidad")))+anywheresoftware.b4a.keywords.Common.CRLF+"Fecha: "+_fecha;
 //BA.debugLineNum = 134;BA.debugLine="Msgbox(msg, \"Atención médica\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence("Atención médica"),mostCurrent.activityBA);
 //BA.debugLineNum = 135;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"No hay atención este día\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No hay atención este día"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
