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

public class registrar extends Activity implements B4AActivity{
	public static registrar mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registrar");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registrar).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.registrar");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.registrar", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registrar) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registrar) Resume **");
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
		return registrar.class;
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
            BA.LogInfo("** Activity (registrar) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registrar) Pause event (activity is not paused). **");
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
            registrar mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registrar) Resume **");
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
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _txt_password2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _txt_rut = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _txt_password = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.starter _starter = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Activity.LoadLayout(\"CrearUsuario\")";
mostCurrent._activity.LoadLayout("CrearUsuario",mostCurrent.activityBA);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registrar";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _btn_limpiarpass_click() throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_limpiarpass_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_limpiarpass_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub Btn_limpiarPass_Click";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return "";
}
public static String  _btn_limpiarrut_click() throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_limpiarrut_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_limpiarrut_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub Btn_limpiarRut_Click";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public static String  _btn_regisdtrar_click() throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_regisdtrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_regisdtrar_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub Btn_Regisdtrar_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If ValidarRUT(Txt_Rut.Text) = False Then";
if (_validarrut(mostCurrent._txt_rut.getText())==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Label3.Visible = True";
mostCurrent._label3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="If Txt_password2.Text <> Txt_password.text Then";
if ((mostCurrent._txt_password2.getText()).equals(mostCurrent._txt_password.getText()) == false) { 
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="Label4.Visible = True";
mostCurrent._label4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="RegistrarNuevoUsuario(Txt_Rut.Text,Txt_password.T";
_registrarnuevousuario(mostCurrent._txt_rut.getText(),mostCurrent._txt_password.getText());
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarrut(String _ruttexto) throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarrut", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarrut", new Object[] {_ruttexto}));}
String _rut = "";
String _cuerpo = "";
String _dvingresado = "";
int _suma = 0;
int _multiplicador = 0;
int _i = 0;
int _digito = 0;
int _resto = 0;
String _dvcalculado = "";
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub ValidarRUT(RutTexto As String) As Boolean";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Dim rut As String = RutTexto.Trim.ToUpperCase";
_rut = _ruttexto.trim().toUpperCase();
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="If Regex.IsMatch(\"[^0-9Kk\\.\\-]\", rut) Then Return";
if (anywheresoftware.b4a.keywords.Common.Regex.IsMatch("[^0-9Kk\\.\\-]",_rut)) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="rut = rut.Replace(\".\", \"\").Replace(\"-\", \"\")";
_rut = _rut.replace(".","").replace("-","");
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="If rut.Length < 2 Then Return False";
if (_rut.length()<2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=1835021;
 //BA.debugLineNum = 1835021;BA.debugLine="Dim cuerpo As String = rut.SubString2(0, rut.Leng";
_cuerpo = _rut.substring((int) (0),(int) (_rut.length()-1));
RDebugUtils.currentLine=1835022;
 //BA.debugLineNum = 1835022;BA.debugLine="Dim dvIngresado As String = rut.SubString(rut.Len";
_dvingresado = _rut.substring((int) (_rut.length()-1));
RDebugUtils.currentLine=1835025;
 //BA.debugLineNum = 1835025;BA.debugLine="If Regex.IsMatch(\"[^0-9]\", cuerpo) Then Return Fa";
if (anywheresoftware.b4a.keywords.Common.Regex.IsMatch("[^0-9]",_cuerpo)) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=1835028;
 //BA.debugLineNum = 1835028;BA.debugLine="Dim suma As Int = 0";
_suma = (int) (0);
RDebugUtils.currentLine=1835029;
 //BA.debugLineNum = 1835029;BA.debugLine="Dim multiplicador As Int = 2";
_multiplicador = (int) (2);
RDebugUtils.currentLine=1835031;
 //BA.debugLineNum = 1835031;BA.debugLine="For i = cuerpo.Length - 1 To 0 Step -1";
{
final int step10 = -1;
final int limit10 = (int) (0);
_i = (int) (_cuerpo.length()-1) ;
for (;_i >= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=1835032;
 //BA.debugLineNum = 1835032;BA.debugLine="Dim digito As Int = Bit.ParseInt(\"\" & cuerpo.Cha";
_digito = anywheresoftware.b4a.keywords.Common.Bit.ParseInt(""+BA.ObjectToString(_cuerpo.charAt(_i)),(int) (10));
RDebugUtils.currentLine=1835033;
 //BA.debugLineNum = 1835033;BA.debugLine="suma = suma + digito * multiplicador";
_suma = (int) (_suma+_digito*_multiplicador);
RDebugUtils.currentLine=1835034;
 //BA.debugLineNum = 1835034;BA.debugLine="multiplicador = multiplicador + 1";
_multiplicador = (int) (_multiplicador+1);
RDebugUtils.currentLine=1835035;
 //BA.debugLineNum = 1835035;BA.debugLine="If multiplicador > 7 Then multiplicador = 2";
if (_multiplicador>7) { 
_multiplicador = (int) (2);};
 }
};
RDebugUtils.currentLine=1835038;
 //BA.debugLineNum = 1835038;BA.debugLine="Dim resto As Int = suma Mod 11";
_resto = (int) (_suma%11);
RDebugUtils.currentLine=1835039;
 //BA.debugLineNum = 1835039;BA.debugLine="Dim dvCalculado As String";
_dvcalculado = "";
RDebugUtils.currentLine=1835040;
 //BA.debugLineNum = 1835040;BA.debugLine="Select Case 11 - resto";
switch (BA.switchObjectToInt(11-_resto,11,10)) {
case 0: {
RDebugUtils.currentLine=1835042;
 //BA.debugLineNum = 1835042;BA.debugLine="dvCalculado = \"0\"";
_dvcalculado = "0";
 break; }
case 1: {
RDebugUtils.currentLine=1835044;
 //BA.debugLineNum = 1835044;BA.debugLine="dvCalculado = \"K\"";
_dvcalculado = "K";
 break; }
default: {
RDebugUtils.currentLine=1835046;
 //BA.debugLineNum = 1835046;BA.debugLine="dvCalculado = (11 - resto)";
_dvcalculado = BA.NumberToString((11-_resto));
 break; }
}
;
RDebugUtils.currentLine=1835050;
 //BA.debugLineNum = 1835050;BA.debugLine="Return dvCalculado = dvIngresado";
if (true) return (_dvcalculado).equals(_dvingresado);
RDebugUtils.currentLine=1835051;
 //BA.debugLineNum = 1835051;BA.debugLine="End Sub";
return false;
}
public static String  _registrarnuevousuario(String _rut,String _contrasena) throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "registrarnuevousuario", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "registrarnuevousuario", new Object[] {_rut,_contrasena}));}
anywheresoftware.b4a.objects.collections.List _usuarios = null;
anywheresoftware.b4a.objects.collections.Map _u = null;
anywheresoftware.b4a.objects.collections.Map _nuevo = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub RegistrarNuevoUsuario(Rut As String, Contrasen";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim usuarios As List";
_usuarios = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="usuarios.Initialize";
_usuarios.Initialize();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Rut = Rut.ToUpperCase.Replace(\".\", \"\")";
_rut = _rut.toUpperCase().replace(".","");
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="usuarios = CargarUsuarios";
_usuarios = _cargarusuarios();
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="For Each u As Map In usuarios";
_u = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group5 = _usuarios;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_u = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group5.Get(index5)));
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="If u.Get(\"Rut\") = Rut Then";
if ((_u.Get((Object)("Rut"))).equals((Object)(_rut))) { 
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="ToastMessageShow(\"El RUT ya está registrado\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("El RUT ya está registrado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="Dim nuevo As Map";
_nuevo = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="nuevo.Initialize";
_nuevo.Initialize();
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="nuevo.Put(\"Rut\", Rut)";
_nuevo.Put((Object)("Rut"),(Object)(_rut));
RDebugUtils.currentLine=1507347;
 //BA.debugLineNum = 1507347;BA.debugLine="nuevo.Put(\"Contrasena\", Contrasena)";
_nuevo.Put((Object)("Contrasena"),(Object)(_contrasena));
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="usuarios.Add(nuevo)";
_usuarios.Add((Object)(_nuevo.getObject()));
RDebugUtils.currentLine=1507350;
 //BA.debugLineNum = 1507350;BA.debugLine="GuardarUsuarios(usuarios)";
_guardarusuarios(_usuarios);
RDebugUtils.currentLine=1507352;
 //BA.debugLineNum = 1507352;BA.debugLine="ToastMessageShow(\"Usuario registrado\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Usuario registrado"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button2_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub Button2_Click";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _cargarusuarios() throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cargarusuarios", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "cargarusuarios", null));}
anywheresoftware.b4a.objects.collections.List _lista = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _jp = null;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub CargarUsuarios() As List";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim Lista As List";
_lista = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Lista.Initialize";
_lista.Initialize();
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="If File.Exists(File.DirInternal, \"usuarios.json\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"usuarios.json")) { 
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="Dim json As String = File.ReadString(File.DirInt";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"usuarios.json");
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="Dim jp As JSONParser";
_jp = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="jp.Initialize(json)";
_jp.Initialize(_json);
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="Lista = jp.NextArray";
_lista = _jp.NextArray();
 };
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="Return Lista";
if (true) return _lista;
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="End Sub";
return null;
}
public static String  _guardarusuarios(anywheresoftware.b4a.objects.collections.List _listausuarios) throws Exception{
RDebugUtils.currentModule="registrar";
if (Debug.shouldDelegate(mostCurrent.activityBA, "guardarusuarios", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "guardarusuarios", new Object[] {_listausuarios}));}
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jgen = null;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub GuardarUsuarios(ListaUsuarios As List)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim jgen As JSONGenerator";
_jgen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="jgen.Initialize2(ListaUsuarios)";
_jgen.Initialize2(_listausuarios);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="File.WriteString(File.DirInternal, \"usuarios.json";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"usuarios.json",_jgen.ToString());
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="End Sub";
return "";
}
}