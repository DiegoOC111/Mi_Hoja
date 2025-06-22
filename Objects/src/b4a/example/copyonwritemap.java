package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class copyonwritemap extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.copyonwritemap");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.copyonwritemap.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _internalmap = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.calendario _calendario = null;
public b4a.example.starter _starter = null;
public b4a.example.verexamenes _verexamenes = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public String  _class_globals(b4a.example.copyonwritemap __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=11272193;
 //BA.debugLineNum = 11272193;BA.debugLine="Private InternalMap As Map";
_internalmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="End Sub";
return "";
}
public String  _clear(b4a.example.copyonwritemap __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "clear", true))
	 {return ((String) Debug.delegate(ba, "clear", null));}
RDebugUtils.currentLine=11730944;
 //BA.debugLineNum = 11730944;BA.debugLine="Public Sub Clear";
RDebugUtils.currentLine=11730945;
 //BA.debugLineNum = 11730945;BA.debugLine="Dim InternalMap As Map";
_internalmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=11730946;
 //BA.debugLineNum = 11730946;BA.debugLine="InternalMap.Initialize";
__ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
RDebugUtils.currentLine=11730947;
 //BA.debugLineNum = 11730947;BA.debugLine="End Sub";
return "";
}
public boolean  _containskey(b4a.example.copyonwritemap __ref,Object _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "containskey", true))
	 {return ((Boolean) Debug.delegate(ba, "containskey", new Object[] {_key}));}
RDebugUtils.currentLine=11862016;
 //BA.debugLineNum = 11862016;BA.debugLine="Public Sub ContainsKey (Key As Object) As Boolean";
RDebugUtils.currentLine=11862017;
 //BA.debugLineNum = 11862017;BA.debugLine="Return InternalMap.ContainsKey(Key)";
if (true) return __ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey(_key);
RDebugUtils.currentLine=11862018;
 //BA.debugLineNum = 11862018;BA.debugLine="End Sub";
return false;
}
public String  _copymap(b4a.example.copyonwritemap __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "copymap", true))
	 {return ((String) Debug.delegate(ba, "copymap", null));}
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Private Sub CopyMap";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="InternalMap = B4XCollections.MergeMaps(InternalMa";
__ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/  = _b4xcollections._mergemaps /*anywheresoftware.b4a.objects.collections.Map*/ (getActivityBA(),__ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ ,(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="End Sub";
return "";
}
public Object  _get(b4a.example.copyonwritemap __ref,Object _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "get", true))
	 {return ((Object) Debug.delegate(ba, "get", new Object[] {_key}));}
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Public Sub Get (Key As Object) As Object";
RDebugUtils.currentLine=11468801;
 //BA.debugLineNum = 11468801;BA.debugLine="Return InternalMap.Get(Key)";
if (true) return __ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .Get(_key);
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="End Sub";
return null;
}
public Object  _getdefault(b4a.example.copyonwritemap __ref,Object _key,Object _default) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "getdefault", true))
	 {return ((Object) Debug.delegate(ba, "getdefault", new Object[] {_key,_default}));}
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Public Sub GetDefault (Key As Object, Default As O";
RDebugUtils.currentLine=11534337;
 //BA.debugLineNum = 11534337;BA.debugLine="Return InternalMap.GetDefault(Key, Default)";
if (true) return __ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .GetDefault(_key,_default);
RDebugUtils.currentLine=11534338;
 //BA.debugLineNum = 11534338;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.Map  _getmap(b4a.example.copyonwritemap __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "getmap", true))
	 {return ((anywheresoftware.b4a.objects.collections.Map) Debug.delegate(ba, "getmap", null));}
RDebugUtils.currentLine=11927552;
 //BA.debugLineNum = 11927552;BA.debugLine="Public Sub GetMap As Map";
RDebugUtils.currentLine=11927553;
 //BA.debugLineNum = 11927553;BA.debugLine="Return InternalMap";
if (true) return __ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ ;
RDebugUtils.currentLine=11927554;
 //BA.debugLineNum = 11927554;BA.debugLine="End Sub";
return null;
}
public int  _getsize(b4a.example.copyonwritemap __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "getsize", true))
	 {return ((Integer) Debug.delegate(ba, "getsize", null));}
RDebugUtils.currentLine=11796480;
 //BA.debugLineNum = 11796480;BA.debugLine="Public Sub getSize As Int";
RDebugUtils.currentLine=11796481;
 //BA.debugLineNum = 11796481;BA.debugLine="Return InternalMap.Size";
if (true) return __ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .getSize();
RDebugUtils.currentLine=11796482;
 //BA.debugLineNum = 11796482;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(b4a.example.copyonwritemap __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _initialitems) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_initialitems}));}
RDebugUtils.currentLine=11337728;
 //BA.debugLineNum = 11337728;BA.debugLine="Public Sub Initialize (InitialItems As Map)";
RDebugUtils.currentLine=11337729;
 //BA.debugLineNum = 11337729;BA.debugLine="InternalMap = B4XCollections.MergeMaps(InitialIte";
__ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/  = _b4xcollections._mergemaps /*anywheresoftware.b4a.objects.collections.Map*/ (getActivityBA(),_initialitems,(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
RDebugUtils.currentLine=11337730;
 //BA.debugLineNum = 11337730;BA.debugLine="End Sub";
return "";
}
public String  _put(b4a.example.copyonwritemap __ref,Object _key,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "put", true))
	 {return ((String) Debug.delegate(ba, "put", new Object[] {_key,_value}));}
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Public Sub Put (Key As Object, Value As Object)";
RDebugUtils.currentLine=11599873;
 //BA.debugLineNum = 11599873;BA.debugLine="CopyMap";
__ref._copymap /*String*/ (null);
RDebugUtils.currentLine=11599874;
 //BA.debugLineNum = 11599874;BA.debugLine="InternalMap.Put(Key, Value)";
__ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put(_key,_value);
RDebugUtils.currentLine=11599875;
 //BA.debugLineNum = 11599875;BA.debugLine="End Sub";
return "";
}
public String  _remove(b4a.example.copyonwritemap __ref,Object _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="copyonwritemap";
if (Debug.shouldDelegate(ba, "remove", true))
	 {return ((String) Debug.delegate(ba, "remove", new Object[] {_key}));}
RDebugUtils.currentLine=11665408;
 //BA.debugLineNum = 11665408;BA.debugLine="Public Sub Remove (Key As Object)";
RDebugUtils.currentLine=11665409;
 //BA.debugLineNum = 11665409;BA.debugLine="CopyMap";
__ref._copymap /*String*/ (null);
RDebugUtils.currentLine=11665410;
 //BA.debugLineNum = 11665410;BA.debugLine="InternalMap.Remove(Key)";
__ref._internalmap /*anywheresoftware.b4a.objects.collections.Map*/ .Remove(_key);
RDebugUtils.currentLine=11665411;
 //BA.debugLineNum = 11665411;BA.debugLine="End Sub";
return "";
}
}