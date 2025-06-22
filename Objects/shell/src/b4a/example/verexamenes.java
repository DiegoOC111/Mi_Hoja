
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

public class verexamenes implements IRemote{
	public static verexamenes mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public verexamenes() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("verexamenes"), "b4a.example.verexamenes");
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
		pcBA = new PCBA(this, verexamenes.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _listaexamenes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _imageviewer = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _clv_examenes = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _mainpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelexa = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.menu _menu = null;
public static b4a.example.registrar _registrar = null;
public static b4a.example.modulo_seleccion _modulo_seleccion = null;
public static b4a.example.modulogestion _modulogestion = null;
public static b4a.example.calendario _calendario = null;
public static b4a.example.starter _starter = null;
public static b4a.example.b4xcollections _b4xcollections = null;
public static b4a.example.xuiviewsutils _xuiviewsutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",verexamenes.mostCurrent._activity,"B4XCollections",Debug.moduleToString(b4a.example.b4xcollections.class),"Calendario",Debug.moduleToString(b4a.example.calendario.class),"CLV_Examenes",verexamenes.mostCurrent._clv_examenes,"DateUtils",verexamenes.mostCurrent._dateutils,"ImageViewer",verexamenes.mostCurrent._imageviewer,"listaExamenes",verexamenes.mostCurrent._listaexamenes,"Main",Debug.moduleToString(b4a.example.main.class),"MainPanel",verexamenes.mostCurrent._mainpanel,"Menu",Debug.moduleToString(b4a.example.menu.class),"Modulo_Seleccion",Debug.moduleToString(b4a.example.modulo_seleccion.class),"ModuloGestion",Debug.moduleToString(b4a.example.modulogestion.class),"Panel1",verexamenes.mostCurrent._panel1,"PanelEXA",verexamenes.mostCurrent._panelexa,"Registrar",Debug.moduleToString(b4a.example.registrar.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"xui",verexamenes.mostCurrent._xui,"XUIViewsUtils",Debug.moduleToString(b4a.example.xuiviewsutils.class)};
}
}