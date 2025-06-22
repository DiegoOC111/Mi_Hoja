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

public class verexamenes extends Activity implements B4AActivity{
	public static verexamenes mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.verexamenes");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (verexamenes).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.verexamenes");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.verexamenes", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (verexamenes) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (verexamenes) Resume **");
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
		return verexamenes.class;
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
            BA.LogInfo("** Activity (verexamenes) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (verexamenes) Pause event (activity is not paused). **");
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
            verexamenes mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (verexamenes) Resume **");
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
public anywheresoftware.b4a.objects.collections.List _listaexamenes = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageviewer = null;
public b4a.example3.customlistview _clv_examenes = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _mainpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelexa = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.calendario _calendario = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=35258368;
 //BA.debugLineNum = 35258368;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=35258370;
 //BA.debugLineNum = 35258370;BA.debugLine="Activity.LoadLayout(\"VistaExamenes\")";
mostCurrent._activity.LoadLayout("VistaExamenes",mostCurrent.activityBA);
RDebugUtils.currentLine=35258371;
 //BA.debugLineNum = 35258371;BA.debugLine="CrearArchivoExamenesSiNoExiste";
_creararchivoexamenessinoexiste();
RDebugUtils.currentLine=35258372;
 //BA.debugLineNum = 35258372;BA.debugLine="CargarExamenes";
_cargarexamenes();
RDebugUtils.currentLine=35258373;
 //BA.debugLineNum = 35258373;BA.debugLine="End Sub";
return "";
}
public static String  _creararchivoexamenessinoexiste() throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creararchivoexamenessinoexiste", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creararchivoexamenessinoexiste", null));}
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.List _examenes = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _ex = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
RDebugUtils.currentLine=35454976;
 //BA.debugLineNum = 35454976;BA.debugLine="Sub CrearArchivoExamenesSiNoExiste";
RDebugUtils.currentLine=35454977;
 //BA.debugLineNum = 35454977;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=35454978;
 //BA.debugLineNum = 35454978;BA.debugLine="Dim archivo As String = \"examenes.json\"";
_archivo = "examenes.json";
RDebugUtils.currentLine=35454980;
 //BA.debugLineNum = 35454980;BA.debugLine="If File.Exists(ruta, archivo) Then Return ' Ya ex";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_archivo)) { 
if (true) return "";};
RDebugUtils.currentLine=35454982;
 //BA.debugLineNum = 35454982;BA.debugLine="Dim examenes As List";
_examenes = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=35454983;
 //BA.debugLineNum = 35454983;BA.debugLine="examenes.Initialize";
_examenes.Initialize();
RDebugUtils.currentLine=35454985;
 //BA.debugLineNum = 35454985;BA.debugLine="For i = 1 To 3";
{
final int step6 = 1;
final int limit6 = (int) (3);
_i = (int) (1) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=35454986;
 //BA.debugLineNum = 35454986;BA.debugLine="Dim ex As Map";
_ex = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=35454987;
 //BA.debugLineNum = 35454987;BA.debugLine="ex.Initialize";
_ex.Initialize();
RDebugUtils.currentLine=35454988;
 //BA.debugLineNum = 35454988;BA.debugLine="ex.Put(\"NombreDelProcedimiento\", \"Radiografía Tó";
_ex.Put((Object)("NombreDelProcedimiento"),(Object)("Radiografía Tórax "+BA.NumberToString(_i)));
RDebugUtils.currentLine=35454989;
 //BA.debugLineNum = 35454989;BA.debugLine="ex.Put(\"RutaImagen\", \"imagen\" & i & \".jpg\")";
_ex.Put((Object)("RutaImagen"),(Object)("imagen"+BA.NumberToString(_i)+".jpg"));
RDebugUtils.currentLine=35454990;
 //BA.debugLineNum = 35454990;BA.debugLine="ex.Put(\"FechaRealizado\", \"15/06/2025\")";
_ex.Put((Object)("FechaRealizado"),(Object)("15/06/2025"));
RDebugUtils.currentLine=35454991;
 //BA.debugLineNum = 35454991;BA.debugLine="ex.Put(\"Rut\", Main.UsuarioActivo.Rut)";
_ex.Put((Object)("Rut"),(Object)(mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ ));
RDebugUtils.currentLine=35454992;
 //BA.debugLineNum = 35454992;BA.debugLine="examenes.Add(ex)";
_examenes.Add((Object)(_ex.getObject()));
 }
};
RDebugUtils.currentLine=35454995;
 //BA.debugLineNum = 35454995;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=35454996;
 //BA.debugLineNum = 35454996;BA.debugLine="gen.Initialize2(examenes)";
_gen.Initialize2(_examenes);
RDebugUtils.currentLine=35454997;
 //BA.debugLineNum = 35454997;BA.debugLine="File.WriteString(ruta, archivo, gen.ToString)";
anywheresoftware.b4a.keywords.Common.File.WriteString(_ruta,_archivo,_gen.ToString());
RDebugUtils.currentLine=35454998;
 //BA.debugLineNum = 35454998;BA.debugLine="End Sub";
return "";
}
public static String  _cargarexamenes() throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargarexamenes", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cargarexamenes", null));}
String _ruta = "";
String _archivo = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _examen = null;
RDebugUtils.currentLine=35520512;
 //BA.debugLineNum = 35520512;BA.debugLine="Sub CargarExamenes";
RDebugUtils.currentLine=35520513;
 //BA.debugLineNum = 35520513;BA.debugLine="listaExamenes.Initialize";
mostCurrent._listaexamenes.Initialize();
RDebugUtils.currentLine=35520514;
 //BA.debugLineNum = 35520514;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
RDebugUtils.currentLine=35520515;
 //BA.debugLineNum = 35520515;BA.debugLine="Dim archivo As String = \"examenes.json\"";
_archivo = "examenes.json";
RDebugUtils.currentLine=35520517;
 //BA.debugLineNum = 35520517;BA.debugLine="If File.Exists(ruta, archivo) = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_ruta,_archivo)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=35520518;
 //BA.debugLineNum = 35520518;BA.debugLine="ToastMessageShow(\"No se encontró el archivo de e";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No se encontró el archivo de exámenes."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35520519;
 //BA.debugLineNum = 35520519;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=35520522;
 //BA.debugLineNum = 35520522;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=35520523;
 //BA.debugLineNum = 35520523;BA.debugLine="parser.Initialize(File.ReadString(ruta, archivo))";
_parser.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(_ruta,_archivo));
RDebugUtils.currentLine=35520524;
 //BA.debugLineNum = 35520524;BA.debugLine="listaExamenes = parser.NextArray";
mostCurrent._listaexamenes = _parser.NextArray();
RDebugUtils.currentLine=35520526;
 //BA.debugLineNum = 35520526;BA.debugLine="CLV_Examenes.Clear";
mostCurrent._clv_examenes._clear();
RDebugUtils.currentLine=35520528;
 //BA.debugLineNum = 35520528;BA.debugLine="For Each examen As Map In listaExamenes";
_examen = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._listaexamenes;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_examen = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group12.Get(index12)));
RDebugUtils.currentLine=35520529;
 //BA.debugLineNum = 35520529;BA.debugLine="If examen.Get(\"Rut\") = Main.UsuarioActivo.Rut Th";
if ((_examen.Get((Object)("Rut"))).equals((Object)(mostCurrent._main._usuarioactivo /*b4a.example.main._usuario*/ .Rut /*String*/ ))) { 
RDebugUtils.currentLine=35520530;
 //BA.debugLineNum = 35520530;BA.debugLine="CLV_Examenes.Add(CreateItemExamen(examen), \"\")";
mostCurrent._clv_examenes._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_createitemexamen(_examen).getObject())),(Object)(""));
 };
 }
};
RDebugUtils.currentLine=35520533;
 //BA.debugLineNum = 35520533;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="verexamenes";
RDebugUtils.currentLine=35389440;
 //BA.debugLineNum = 35389440;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=35389442;
 //BA.debugLineNum = 35389442;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=35323904;
 //BA.debugLineNum = 35323904;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=35323906;
 //BA.debugLineNum = 35323906;BA.debugLine="End Sub";
return "";
}
public static String  _btn_cerrar_click() throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_cerrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_cerrar_click", null));}
RDebugUtils.currentLine=35717120;
 //BA.debugLineNum = 35717120;BA.debugLine="Private Sub Btn_cerrar_Click";
RDebugUtils.currentLine=35717121;
 //BA.debugLineNum = 35717121;BA.debugLine="PanelEXA.Visible  = False";
mostCurrent._panelexa.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35717122;
 //BA.debugLineNum = 35717122;BA.debugLine="MainPanel.Visible = True";
mostCurrent._mainpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35717123;
 //BA.debugLineNum = 35717123;BA.debugLine="End Sub";
return "";
}
public static String  _btn_ver_click() throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_ver_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_ver_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _ruta = "";
RDebugUtils.currentLine=35979264;
 //BA.debugLineNum = 35979264;BA.debugLine="Private Sub Btn_Ver_Click";
RDebugUtils.currentLine=35979265;
 //BA.debugLineNum = 35979265;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=35979266;
 //BA.debugLineNum = 35979266;BA.debugLine="Dim ruta As String = btn.Tag";
_ruta = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=35979268;
 //BA.debugLineNum = 35979268;BA.debugLine="If File.Exists(File.DirAssets, ruta) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ruta)) { 
RDebugUtils.currentLine=35979269;
 //BA.debugLineNum = 35979269;BA.debugLine="PanelEXA.Visible = True";
mostCurrent._panelexa.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=35979271;
 //BA.debugLineNum = 35979271;BA.debugLine="MainPanel.Visible = False";
mostCurrent._mainpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=35979273;
 //BA.debugLineNum = 35979273;BA.debugLine="ImageViewer.Bitmap = LoadBitmap(File.DirAssets,";
mostCurrent._imageviewer.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ruta).getObject()));
 }else {
RDebugUtils.currentLine=35979275;
 //BA.debugLineNum = 35979275;BA.debugLine="ToastMessageShow(\"Imagen no encontrada: \" & ruta";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Imagen no encontrada: "+_ruta),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=35979277;
 //BA.debugLineNum = 35979277;BA.debugLine="End Sub";
return "";
}
public static String  _btnver_click() throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnver_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnver_click", null));}
RDebugUtils.currentLine=35651584;
 //BA.debugLineNum = 35651584;BA.debugLine="Sub BtnVer_Click";
RDebugUtils.currentLine=35651586;
 //BA.debugLineNum = 35651586;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createitemexamen(anywheresoftware.b4a.objects.collections.Map _examen) throws Exception{
RDebugUtils.currentModule="verexamenes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createitemexamen", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "createitemexamen", new Object[] {_examen}));}
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.PanelWrapper _pan = null;
anywheresoftware.b4a.objects.LabelWrapper _lblproc = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfecha = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnver = null;
RDebugUtils.currentLine=35586048;
 //BA.debugLineNum = 35586048;BA.debugLine="Sub CreateItemExamen(examen As Map) As Panel";
RDebugUtils.currentLine=35586049;
 //BA.debugLineNum = 35586049;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=35586050;
 //BA.debugLineNum = 35586050;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, CLV_Examenes.AsView.";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._clv_examenes._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)));
RDebugUtils.currentLine=35586051;
 //BA.debugLineNum = 35586051;BA.debugLine="p.LoadLayout(\"VistaExamen\") ' este es tu layout c";
_p.LoadLayout("VistaExamen",mostCurrent.activityBA);
RDebugUtils.currentLine=35586052;
 //BA.debugLineNum = 35586052;BA.debugLine="Dim PAn As Panel = p.GetView(0)";
_pan = new anywheresoftware.b4a.objects.PanelWrapper();
_pan = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=35586053;
 //BA.debugLineNum = 35586053;BA.debugLine="Dim LblProc As Label = PAn.GetView(0) ' o usa Pan";
_lblproc = new anywheresoftware.b4a.objects.LabelWrapper();
_lblproc = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_pan.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=35586054;
 //BA.debugLineNum = 35586054;BA.debugLine="Dim LblFecha As Label = PAn.GetView(1)";
_lblfecha = new anywheresoftware.b4a.objects.LabelWrapper();
_lblfecha = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_pan.GetView((int) (1)).getObject()));
RDebugUtils.currentLine=35586055;
 //BA.debugLineNum = 35586055;BA.debugLine="Dim BtnVer As Button = PAn.GetView(2)";
_btnver = new anywheresoftware.b4a.objects.ButtonWrapper();
_btnver = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(_pan.GetView((int) (2)).getObject()));
RDebugUtils.currentLine=35586057;
 //BA.debugLineNum = 35586057;BA.debugLine="LblProc.Text = examen.Get(\"NombreDelProcedimiento";
_lblproc.setText(BA.ObjectToCharSequence(_examen.Get((Object)("NombreDelProcedimiento"))));
RDebugUtils.currentLine=35586058;
 //BA.debugLineNum = 35586058;BA.debugLine="LblFecha.Text = examen.Get(\"FechaRealizado\")";
_lblfecha.setText(BA.ObjectToCharSequence(_examen.Get((Object)("FechaRealizado"))));
RDebugUtils.currentLine=35586060;
 //BA.debugLineNum = 35586060;BA.debugLine="BtnVer.Tag = examen.Get(\"RutaImagen\")";
_btnver.setTag(_examen.Get((Object)("RutaImagen")));
RDebugUtils.currentLine=35586062;
 //BA.debugLineNum = 35586062;BA.debugLine="Return p";
if (true) return (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.getObject()));
RDebugUtils.currentLine=35586063;
 //BA.debugLineNum = 35586063;BA.debugLine="End Sub";
return null;
}
}