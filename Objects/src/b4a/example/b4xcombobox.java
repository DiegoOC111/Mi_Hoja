package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xcombobox extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.b4xcombobox");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xcombobox.class).invoke(this, new Object[] {null});
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
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public int _lastselectedindex = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _cmbbox = null;
public int _delaybeforechangeevent = 0;
public int _delayindex = 0;
public Object _tag = null;
public String _b4icancelbutton = "";
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
public String  _base_resize(b4a.example.b4xcombobox __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "base_resize", true))
	 {return ((String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=17498112;
 //BA.debugLineNum = 17498112;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
RDebugUtils.currentLine=17498113;
 //BA.debugLineNum = 17498113;BA.debugLine="mBase.GetView(0).SetLayoutAnimated(0, 0, 0, Width";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .GetView((int) (0)).SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
RDebugUtils.currentLine=17498114;
 //BA.debugLineNum = 17498114;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.b4xcombobox __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=17301505;
 //BA.debugLineNum = 17301505;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=17301507;
 //BA.debugLineNum = 17301507;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=17301508;
 //BA.debugLineNum = 17301508;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=17301509;
 //BA.debugLineNum = 17301509;BA.debugLine="Private LastSelectedIndex As Int";
_lastselectedindex = 0;
RDebugUtils.currentLine=17301513;
 //BA.debugLineNum = 17301513;BA.debugLine="Public cmbBox As Spinner";
_cmbbox = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=17301519;
 //BA.debugLineNum = 17301519;BA.debugLine="Public DelayBeforeChangeEvent As Int";
_delaybeforechangeevent = 0;
RDebugUtils.currentLine=17301521;
 //BA.debugLineNum = 17301521;BA.debugLine="Private DelayIndex As Int";
_delayindex = 0;
RDebugUtils.currentLine=17301522;
 //BA.debugLineNum = 17301522;BA.debugLine="Public Tag As Object";
_tag = new Object();
RDebugUtils.currentLine=17301523;
 //BA.debugLineNum = 17301523;BA.debugLine="Public B4iCancelButton As String = \"Cancel\"";
_b4icancelbutton = "Cancel";
RDebugUtils.currentLine=17301524;
 //BA.debugLineNum = 17301524;BA.debugLine="End Sub";
return "";
}
public String  _cmbbox_itemclick(b4a.example.b4xcombobox __ref,int _position,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "cmbbox_itemclick", true))
	 {return ((String) Debug.delegate(ba, "cmbbox_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=18087936;
 //BA.debugLineNum = 18087936;BA.debugLine="Private Sub CmbBox_ItemClick (Position As Int, Val";
RDebugUtils.currentLine=18087937;
 //BA.debugLineNum = 18087937;BA.debugLine="RaiseEvent";
__ref._raiseevent /*void*/ (null);
RDebugUtils.currentLine=18087938;
 //BA.debugLineNum = 18087938;BA.debugLine="End Sub";
return "";
}
public void  _raiseevent(b4a.example.b4xcombobox __ref) throws Exception{
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "raiseevent", true))
	 {Debug.delegate(ba, "raiseevent", null); return;}
ResumableSub_RaiseEvent rsub = new ResumableSub_RaiseEvent(this,__ref);
rsub.resume(ba, null);
}
public static class ResumableSub_RaiseEvent extends BA.ResumableSub {
public ResumableSub_RaiseEvent(b4a.example.b4xcombobox parent,b4a.example.b4xcombobox __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
b4a.example.b4xcombobox __ref;
b4a.example.b4xcombobox parent;
int _index = 0;
int _myindex = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xcombobox";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=18022401;
 //BA.debugLineNum = 18022401;BA.debugLine="Dim index As Int = getSelectedIndex";
_index = __ref._getselectedindex /*int*/ (null);
RDebugUtils.currentLine=18022402;
 //BA.debugLineNum = 18022402;BA.debugLine="If LastSelectedIndex = index Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (__ref._lastselectedindex /*int*/ ==_index) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=18022403;
 //BA.debugLineNum = 18022403;BA.debugLine="If DelayBeforeChangeEvent > 0 Then";
if (true) break;

case 7:
//if
this.state = 16;
if (__ref._delaybeforechangeevent /*int*/ >0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=18022404;
 //BA.debugLineNum = 18022404;BA.debugLine="DelayIndex = DelayIndex + 1";
__ref._delayindex /*int*/  = (int) (__ref._delayindex /*int*/ +1);
RDebugUtils.currentLine=18022405;
 //BA.debugLineNum = 18022405;BA.debugLine="Dim MyIndex As Int = DelayIndex";
_myindex = __ref._delayindex /*int*/ ;
RDebugUtils.currentLine=18022406;
 //BA.debugLineNum = 18022406;BA.debugLine="Sleep(DelayBeforeChangeEvent)";
parent.__c.Sleep(ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xcombobox", "raiseevent"),__ref._delaybeforechangeevent /*int*/ );
this.state = 21;
return;
case 21:
//C
this.state = 10;
;
RDebugUtils.currentLine=18022407;
 //BA.debugLineNum = 18022407;BA.debugLine="If MyIndex <> DelayIndex Then Return";
if (true) break;

case 10:
//if
this.state = 15;
if (_myindex!=__ref._delayindex /*int*/ ) { 
this.state = 12;
;}if (true) break;

case 12:
//C
this.state = 15;
if (true) return ;
if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = 17;
;
RDebugUtils.currentLine=18022409;
 //BA.debugLineNum = 18022409;BA.debugLine="LastSelectedIndex = index";
__ref._lastselectedindex /*int*/  = _index;
RDebugUtils.currentLine=18022410;
 //BA.debugLineNum = 18022410;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Select";
if (true) break;

case 17:
//if
this.state = 20;
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .SubExists(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_SelectedIndexChanged",(int) (1))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=18022411;
 //BA.debugLineNum = 18022411;BA.debugLine="CallSub2(mCallBack, mEventName & \"_SelectedIndex";
parent.__c.CallSubNew2(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_SelectedIndexChanged",(Object)(_index));
 if (true) break;

case 20:
//C
this.state = -1;
;
RDebugUtils.currentLine=18022413;
 //BA.debugLineNum = 18022413;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _designercreateview(b4a.example.b4xcombobox __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "designercreateview", true))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
anywheresoftware.b4a.objects.B4XViewWrapper _xlbl = null;
RDebugUtils.currentLine=17432576;
 //BA.debugLineNum = 17432576;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=17432577;
 //BA.debugLineNum = 17432577;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
RDebugUtils.currentLine=17432578;
 //BA.debugLineNum = 17432578;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
__ref._tag /*Object*/  = __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag();
RDebugUtils.currentLine=17432578;
 //BA.debugLineNum = 17432578;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTag(this);
RDebugUtils.currentLine=17432579;
 //BA.debugLineNum = 17432579;BA.debugLine="Dim xlbl As B4XView = Lbl";
_xlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
RDebugUtils.currentLine=17432586;
 //BA.debugLineNum = 17432586;BA.debugLine="cmbBox.Initialize(\"cmbBox\")";
__ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .Initialize(ba,"cmbBox");
RDebugUtils.currentLine=17432587;
 //BA.debugLineNum = 17432587;BA.debugLine="cmbBox.TextSize = xlbl.TextSize";
__ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setTextSize(_xlbl.getTextSize());
RDebugUtils.currentLine=17432588;
 //BA.debugLineNum = 17432588;BA.debugLine="mBase.AddView(cmbBox, 0, 0, mBase.Width, mBase.He";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=17432597;
 //BA.debugLineNum = 17432597;BA.debugLine="End Sub";
return "";
}
public String  _getitem(b4a.example.b4xcombobox __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "getitem", true))
	 {return ((String) Debug.delegate(ba, "getitem", new Object[] {_index}));}
RDebugUtils.currentLine=17956864;
 //BA.debugLineNum = 17956864;BA.debugLine="Public Sub GetItem(Index As Int) As String";
RDebugUtils.currentLine=17956868;
 //BA.debugLineNum = 17956868;BA.debugLine="Return cmbBox.GetItem(Index)";
if (true) return __ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .GetItem(_index);
RDebugUtils.currentLine=17956872;
 //BA.debugLineNum = 17956872;BA.debugLine="End Sub";
return "";
}
public int  _getselectedindex(b4a.example.b4xcombobox __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "getselectedindex", true))
	 {return ((Integer) Debug.delegate(ba, "getselectedindex", null));}
RDebugUtils.currentLine=17760256;
 //BA.debugLineNum = 17760256;BA.debugLine="Public Sub getSelectedIndex As Int";
RDebugUtils.currentLine=17760258;
 //BA.debugLineNum = 17760258;BA.debugLine="Return cmbBox.SelectedIndex";
if (true) return __ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .getSelectedIndex();
RDebugUtils.currentLine=17760262;
 //BA.debugLineNum = 17760262;BA.debugLine="End Sub";
return 0;
}
public String  _getselecteditem(b4a.example.b4xcombobox __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "getselecteditem", true))
	 {return ((String) Debug.delegate(ba, "getselecteditem", null));}
int _i = 0;
RDebugUtils.currentLine=17891328;
 //BA.debugLineNum = 17891328;BA.debugLine="Public Sub getSelectedItem As String";
RDebugUtils.currentLine=17891329;
 //BA.debugLineNum = 17891329;BA.debugLine="Dim i As Int = getSelectedIndex";
_i = __ref._getselectedindex /*int*/ (null);
RDebugUtils.currentLine=17891330;
 //BA.debugLineNum = 17891330;BA.debugLine="If i = -1 Then Return \"\"";
if (_i==-1) { 
if (true) return "";};
RDebugUtils.currentLine=17891331;
 //BA.debugLineNum = 17891331;BA.debugLine="Return GetItem(i)";
if (true) return __ref._getitem /*String*/ (null,_i);
RDebugUtils.currentLine=17891332;
 //BA.debugLineNum = 17891332;BA.debugLine="End Sub";
return "";
}
public int  _getsize(b4a.example.b4xcombobox __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "getsize", true))
	 {return ((Integer) Debug.delegate(ba, "getsize", null));}
RDebugUtils.currentLine=17629184;
 //BA.debugLineNum = 17629184;BA.debugLine="Public Sub getSize As Int";
RDebugUtils.currentLine=17629188;
 //BA.debugLineNum = 17629188;BA.debugLine="Return cmbBox.Size";
if (true) return __ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .getSize();
RDebugUtils.currentLine=17629192;
 //BA.debugLineNum = 17629192;BA.debugLine="End Sub";
return 0;
}
public int  _indexof(b4a.example.b4xcombobox __ref,String _item) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "indexof", true))
	 {return ((Integer) Debug.delegate(ba, "indexof", new Object[] {_item}));}
RDebugUtils.currentLine=17694720;
 //BA.debugLineNum = 17694720;BA.debugLine="Public Sub IndexOf(Item As String) As Int";
RDebugUtils.currentLine=17694724;
 //BA.debugLineNum = 17694724;BA.debugLine="Return cmbBox.IndexOf(Item)";
if (true) return __ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .IndexOf(_item);
RDebugUtils.currentLine=17694728;
 //BA.debugLineNum = 17694728;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(b4a.example.b4xcombobox __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=17367040;
 //BA.debugLineNum = 17367040;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=17367041;
 //BA.debugLineNum = 17367041;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=17367042;
 //BA.debugLineNum = 17367042;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=17367043;
 //BA.debugLineNum = 17367043;BA.debugLine="LastSelectedIndex = -1";
__ref._lastselectedindex /*int*/  = (int) (-1);
RDebugUtils.currentLine=17367044;
 //BA.debugLineNum = 17367044;BA.debugLine="If xui.IsB4J Then DelayBeforeChangeEvent = 500";
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .getIsB4J()) { 
__ref._delaybeforechangeevent /*int*/  = (int) (500);};
RDebugUtils.currentLine=17367045;
 //BA.debugLineNum = 17367045;BA.debugLine="End Sub";
return "";
}
public String  _setitems(b4a.example.b4xcombobox __ref,anywheresoftware.b4a.objects.collections.List _items) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "setitems", true))
	 {return ((String) Debug.delegate(ba, "setitems", new Object[] {_items}));}
RDebugUtils.currentLine=17563648;
 //BA.debugLineNum = 17563648;BA.debugLine="Public Sub SetItems(Items As List)";
RDebugUtils.currentLine=17563653;
 //BA.debugLineNum = 17563653;BA.debugLine="cmbBox.Clear";
__ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .Clear();
RDebugUtils.currentLine=17563654;
 //BA.debugLineNum = 17563654;BA.debugLine="cmbBox.AddAll(Items)";
__ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .AddAll(_items);
RDebugUtils.currentLine=17563661;
 //BA.debugLineNum = 17563661;BA.debugLine="If Items.Size > 0 Then setSelectedIndex(0)";
if (_items.getSize()>0) { 
__ref._setselectedindex /*String*/ (null,(int) (0));};
RDebugUtils.currentLine=17563662;
 //BA.debugLineNum = 17563662;BA.debugLine="End Sub";
return "";
}
public String  _setselectedindex(b4a.example.b4xcombobox __ref,int _i) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xcombobox";
if (Debug.shouldDelegate(ba, "setselectedindex", true))
	 {return ((String) Debug.delegate(ba, "setselectedindex", new Object[] {_i}));}
RDebugUtils.currentLine=17825792;
 //BA.debugLineNum = 17825792;BA.debugLine="Public Sub setSelectedIndex(i As Int)";
RDebugUtils.currentLine=17825793;
 //BA.debugLineNum = 17825793;BA.debugLine="LastSelectedIndex = i";
__ref._lastselectedindex /*int*/  = _i;
RDebugUtils.currentLine=17825795;
 //BA.debugLineNum = 17825795;BA.debugLine="cmbBox.SelectedIndex = i";
__ref._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setSelectedIndex(_i);
RDebugUtils.currentLine=17825804;
 //BA.debugLineNum = 17825804;BA.debugLine="End Sub";
return "";
}
}