
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

public class modulo_seleccion implements IRemote{
	public static modulo_seleccion mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public modulo_seleccion() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("modulo_seleccion"), "b4a.example.modulo_seleccion");
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
		pcBA = new PCBA(this, modulo_seleccion.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _listadoctores = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _spiner_especialidad = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _doctoreslist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _lbl_nombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_especialidad = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _img_doc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _doctorseleccionado = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _fechaseleccionada = RemoteObject.createImmutable("");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.menu _menu = null;
public static b4a.example.registrar _registrar = null;
public static b4a.example.starter _starter = null;
public static b4a.example.modulogestion _modulogestion = null;
public static b4a.example.b4xcollections _b4xcollections = null;
public static b4a.example.xuiviewsutils _xuiviewsutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",modulo_seleccion.mostCurrent._activity,"B4XCollections",Debug.moduleToString(b4a.example.b4xcollections.class),"DateUtils",modulo_seleccion.mostCurrent._dateutils,"doctoresList",modulo_seleccion.mostCurrent._doctoreslist,"DoctorSeleccionado",modulo_seleccion.mostCurrent._doctorseleccionado,"FechaSeleccionada",modulo_seleccion.mostCurrent._fechaseleccionada,"IMG_Doc",modulo_seleccion.mostCurrent._img_doc,"Lbl_especialidad",modulo_seleccion.mostCurrent._lbl_especialidad,"Lbl_nombre",modulo_seleccion.mostCurrent._lbl_nombre,"ListaDoctores",modulo_seleccion.mostCurrent._listadoctores,"Main",Debug.moduleToString(b4a.example.main.class),"Menu",Debug.moduleToString(b4a.example.menu.class),"ModuloGestion",Debug.moduleToString(b4a.example.modulogestion.class),"Registrar",Debug.moduleToString(b4a.example.registrar.class),"Spiner_especialidad",modulo_seleccion.mostCurrent._spiner_especialidad,"Starter",Debug.moduleToString(b4a.example.starter.class),"xui",modulo_seleccion.mostCurrent._xui,"XUIViewsUtils",Debug.moduleToString(b4a.example.xuiviewsutils.class)};
}
}