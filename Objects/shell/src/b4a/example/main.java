
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _usuarioactivo = RemoteObject.declareNull("b4a.example.main._usuario");
public static RemoteObject _txt_rut = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _txt_password = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.menu _menu = null;
public static b4a.example.registrar _registrar = null;
public static b4a.example.modulo_seleccion _modulo_seleccion = null;
public static b4a.example.modulogestion _modulogestion = null;
public static b4a.example.calendario _calendario = null;
public static b4a.example.starter _starter = null;
public static b4a.example.verexamenes _verexamenes = null;
public static b4a.example.b4xcollections _b4xcollections = null;
public static b4a.example.xuiviewsutils _xuiviewsutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"B4XCollections",Debug.moduleToString(b4a.example.b4xcollections.class),"Calendario",Debug.moduleToString(b4a.example.calendario.class),"DateUtils",main.mostCurrent._dateutils,"Menu",Debug.moduleToString(b4a.example.menu.class),"Modulo_Seleccion",Debug.moduleToString(b4a.example.modulo_seleccion.class),"ModuloGestion",Debug.moduleToString(b4a.example.modulogestion.class),"Registrar",Debug.moduleToString(b4a.example.registrar.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"Txt_password",main.mostCurrent._txt_password,"Txt_Rut",main.mostCurrent._txt_rut,"UsuarioActivo",main._usuarioactivo,"VerExamenes",Debug.moduleToString(b4a.example.verexamenes.class),"xui",main._xui,"XUIViewsUtils",Debug.moduleToString(b4a.example.xuiviewsutils.class)};
}
}