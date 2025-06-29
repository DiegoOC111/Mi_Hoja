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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static b4a.example.main._usuario _usuarioactivo = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _txt_rut = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _txt_password = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.calendario _calendario = null;
public b4a.example.verexamenes _verexamenes = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (menu.mostCurrent != null);
vis = vis | (registrar.mostCurrent != null);
vis = vis | (modulo_seleccion.mostCurrent != null);
vis = vis | (modulogestion.mostCurrent != null);
vis = vis | (calendario.mostCurrent != null);
vis = vis | (verexamenes.mostCurrent != null);
return vis;}
public static class _usuario{
public boolean IsInitialized;
public String Rut;
public String Contrasena;
public void Initialize() {
IsInitialized = true;
Rut = "";
Contrasena = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 47;BA.debugLine="CrearArchivoDoctores";
_creararchivodoctores();
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _btn_crear_click() throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Private Sub Btn_Crear_Click";
 //BA.debugLineNum = 63;BA.debugLine="StartActivity(Registrar)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrar.getObject()));
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _btn_iniciar_click() throws Exception{
String _rut = "";
String _clave = "";
anywheresoftware.b4a.objects.collections.List _usuarios = null;
anywheresoftware.b4a.objects.collections.Map _u = null;
 //BA.debugLineNum = 66;BA.debugLine="Private Sub Btn_iniciar_Click";
 //BA.debugLineNum = 67;BA.debugLine="Dim rut As String = Txt_Rut.Text";
_rut = mostCurrent._txt_rut.getText();
 //BA.debugLineNum = 68;BA.debugLine="Dim clave As String = Txt_password.Text";
_clave = mostCurrent._txt_password.getText();
 //BA.debugLineNum = 71;BA.debugLine="If rut = \"\" Or clave = \"\" Then";
if ((_rut).equals("") || (_clave).equals("")) { 
 //BA.debugLineNum = 72;BA.debugLine="xui.MsgboxAsync(\"Debes ingresar RUT y contraseña";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Debes ingresar RUT y contraseña"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 73;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 76;BA.debugLine="rut = rut.ToUpperCase.Replace(\".\", \"\")";
_rut = _rut.toUpperCase().replace(".","");
 //BA.debugLineNum = 79;BA.debugLine="Dim usuarios As List = CargarUsuarios";
_usuarios = new anywheresoftware.b4a.objects.collections.List();
_usuarios = _cargarusuarios();
 //BA.debugLineNum = 82;BA.debugLine="For Each u As Map In usuarios";
_u = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group9 = _usuarios;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_u = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group9.Get(index9)));
 //BA.debugLineNum = 83;BA.debugLine="If u.Get(\"Rut\") = rut And u.Get(\"Contrasena\") =";
if ((_u.Get((Object)("Rut"))).equals((Object)(_rut)) && (_u.Get((Object)("Contrasena"))).equals((Object)(_clave))) { 
 //BA.debugLineNum = 84;BA.debugLine="UsuarioActivo.Contrasena = clave";
_usuarioactivo.Contrasena /*String*/  = _clave;
 //BA.debugLineNum = 85;BA.debugLine="UsuarioActivo.Rut = rut";
_usuarioactivo.Rut /*String*/  = _rut;
 //BA.debugLineNum = 86;BA.debugLine="xui.MsgboxAsync(\"Inicio de sesión exitoso\", \"Bi";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Inicio de sesión exitoso"),BA.ObjectToCharSequence("Bienvenido"));
 //BA.debugLineNum = 88;BA.debugLine="StartActivity(Menu)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._menu.getObject()));
 //BA.debugLineNum = 89;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 94;BA.debugLine="xui.MsgboxAsync(\"RUT o contraseña incorrectos\", \"";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("RUT o contraseña incorrectos"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 59;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Hello world!"),BA.ObjectToCharSequence("B4X"));
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _cargarusuarios() throws Exception{
anywheresoftware.b4a.objects.collections.List _lista = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _jp = null;
 //BA.debugLineNum = 32;BA.debugLine="Sub CargarUsuarios() As List";
 //BA.debugLineNum = 33;BA.debugLine="Dim Lista As List";
_lista = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 34;BA.debugLine="Lista.Initialize";
_lista.Initialize();
 //BA.debugLineNum = 36;BA.debugLine="If File.Exists(File.DirInternal, \"usuarios.json\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"usuarios.json")) { 
 //BA.debugLineNum = 37;BA.debugLine="Dim json As String = File.ReadString(File.DirInt";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"usuarios.json");
 //BA.debugLineNum = 38;BA.debugLine="Dim jp As JSONParser";
_jp = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 39;BA.debugLine="jp.Initialize(json)";
_jp.Initialize(_json);
 //BA.debugLineNum = 40;BA.debugLine="Lista = jp.NextArray";
_lista = _jp.NextArray();
 };
 //BA.debugLineNum = 43;BA.debugLine="Return Lista";
if (true) return _lista;
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return null;
}
public static String  _creararchivodoctores() throws Exception{
String _nombrearchivo = "";
String _ruta = "";
String _contenido = "";
 //BA.debugLineNum = 96;BA.debugLine="Sub CrearArchivoDoctores";
 //BA.debugLineNum = 97;BA.debugLine="Dim nombreArchivo As String = \"doctores.json\"";
_nombrearchivo = "doctores.json";
 //BA.debugLineNum = 98;BA.debugLine="Dim ruta As String = File.DirInternal";
_ruta = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 //BA.debugLineNum = 107;BA.debugLine="Dim contenido As String = $\"{   \"doctores\": [";
_contenido = ("{\n"+"  \"doctores\": [\n"+"    {\n"+"      \"nombre_completo\": \"Dra. Valentina Ríos Martínez\",\n"+"      \"especialidad\": \"Cardiología Pediátrica\",\n"+"      \"foto_perfil\": \"valentina_rios.png\"\n"+"    },\n"+"    {\n"+"      \"nombre_completo\": \"Dr. Sebastián Torres Guzmán\",\n"+"      \"especialidad\": \"Pediatría General\",\n"+"      \"foto_perfil\": \"sebastian_torres.png\"\n"+"    },\n"+"    {\n"+"      \"nombre_completo\": \"Dra. Camila Herrera Soto\",\n"+"      \"especialidad\": \"Dermatología Pediátrica\",\n"+"      \"foto_perfil\": \"camila_herrera.png\"\n"+"    },\n"+"    {\n"+"      \"nombre_completo\": \"Dr. Ignacio Fernández Vidal\",\n"+"      \"especialidad\": \"Neurología Pediátrica\",\n"+"      \"foto_perfil\": \"ignacio_fernandez.png\"\n"+"    }\n"+"  ]\n"+"}");
 //BA.debugLineNum = 133;BA.debugLine="File.WriteString(ruta, nombreArchivo, contenido)";
anywheresoftware.b4a.keywords.Common.File.WriteString(_ruta,_nombrearchivo,_contenido);
 //BA.debugLineNum = 134;BA.debugLine="Log(\"Archivo creado correctamente en: \" & ruta)";
anywheresoftware.b4a.keywords.Common.LogImpl("0589862","Archivo creado correctamente en: "+_ruta,0);
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private Txt_Rut As AutoCompleteEditText";
mostCurrent._txt_rut = new anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private Txt_password As AutoCompleteEditText";
mostCurrent._txt_password = new anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
menu._process_globals();
registrar._process_globals();
modulo_seleccion._process_globals();
modulogestion._process_globals();
calendario._process_globals();
verexamenes._process_globals();
starter._process_globals();
b4xcollections._process_globals();
xuiviewsutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 22;BA.debugLine="Type Usuario(Rut As String, Contrasena As String)";
;
 //BA.debugLineNum = 23;BA.debugLine="Public UsuarioActivo As Usuario";
_usuarioactivo = new b4a.example.main._usuario();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
}
