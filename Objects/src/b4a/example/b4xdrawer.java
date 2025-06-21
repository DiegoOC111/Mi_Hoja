package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xdrawer extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.b4xdrawer");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xdrawer.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public int _msidewidth = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper _mleftpanel = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mdarkpanel = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbasepanel = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mcenterpanel = null;
public int _extrawidth = 0;
public float _touchxstart = 0f;
public float _touchystart = 0f;
public boolean _isopen = false;
public boolean _handlingswipe = false;
public boolean _startatscrim = false;
public boolean _menabled = false;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.menu _menu = null;
public b4a.example.registrar _registrar = null;
public b4a.example.modulo_seleccion _modulo_seleccion = null;
public b4a.example.starter _starter = null;
public b4a.example.modulogestion _modulogestion = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public boolean  _base_onintercepttouchevent(b4a.example.b4xdrawer __ref,int _action,float _x,float _y,Object _motionevent) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "base_onintercepttouchevent", true))
	 {return ((Boolean) Debug.delegate(ba, "base_onintercepttouchevent", new Object[] {_action,_x,_y,_motionevent}));}
float _dx = 0f;
float _dy = 0f;
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Private Sub Base_OnInterceptTouchEvent (Action As";
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="If mEnabled = False Then Return False";
if (__ref._menabled /*boolean*/ ==__c.False) { 
if (true) return __c.False;};
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="If IsOpen = False And x > mLeftPanel.Left + mLeft";
if (__ref._isopen /*boolean*/ ==__c.False && _x>__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft()+__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()+__ref._extrawidth /*int*/ ) { 
if (true) return __c.False;};
RDebugUtils.currentLine=10485763;
 //BA.debugLineNum = 10485763;BA.debugLine="If IsOpen And x > mLeftPanel.Left + mLeftPanel.Wi";
if (__ref._isopen /*boolean*/  && _x>__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft()+__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()) { 
RDebugUtils.currentLine=10485765;
 //BA.debugLineNum = 10485765;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=10485767;
 //BA.debugLineNum = 10485767;BA.debugLine="If HandlingSwipe Then Return True";
if (__ref._handlingswipe /*boolean*/ ) { 
if (true) return __c.True;};
RDebugUtils.currentLine=10485768;
 //BA.debugLineNum = 10485768;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_DOWN,__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=10485770;
 //BA.debugLineNum = 10485770;BA.debugLine="TouchXStart = X";
__ref._touchxstart /*float*/  = _x;
RDebugUtils.currentLine=10485771;
 //BA.debugLineNum = 10485771;BA.debugLine="TouchYStart = Y";
__ref._touchystart /*float*/  = _y;
RDebugUtils.currentLine=10485772;
 //BA.debugLineNum = 10485772;BA.debugLine="HandlingSwipe = False";
__ref._handlingswipe /*boolean*/  = __c.False;
 break; }
case 1: {
RDebugUtils.currentLine=10485774;
 //BA.debugLineNum = 10485774;BA.debugLine="Dim dx As Float = Abs(x - TouchXStart)";
_dx = (float) (__c.Abs(_x-__ref._touchxstart /*float*/ ));
RDebugUtils.currentLine=10485775;
 //BA.debugLineNum = 10485775;BA.debugLine="Dim dy As Float = Abs(y - TouchYStart)";
_dy = (float) (__c.Abs(_y-__ref._touchystart /*float*/ ));
RDebugUtils.currentLine=10485776;
 //BA.debugLineNum = 10485776;BA.debugLine="If dy < 20dip And dx > 10dip Then";
if (_dy<__c.DipToCurrent((int) (20)) && _dx>__c.DipToCurrent((int) (10))) { 
RDebugUtils.currentLine=10485777;
 //BA.debugLineNum = 10485777;BA.debugLine="HandlingSwipe = True";
__ref._handlingswipe /*boolean*/  = __c.True;
 };
 break; }
}
;
RDebugUtils.currentLine=10485780;
 //BA.debugLineNum = 10485780;BA.debugLine="Return HandlingSwipe";
if (true) return __ref._handlingswipe /*boolean*/ ;
RDebugUtils.currentLine=10485781;
 //BA.debugLineNum = 10485781;BA.debugLine="End Sub";
return false;
}
public boolean  _base_ontouchevent(b4a.example.b4xdrawer __ref,int _action,float _x,float _y,Object _motionevent) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "base_ontouchevent", true))
	 {return ((Boolean) Debug.delegate(ba, "base_ontouchevent", new Object[] {_action,_x,_y,_motionevent}));}
int _leftpanelrightside = 0;
float _dx = 0f;
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Private Sub Base_OnTouchEvent (Action As Int, X As";
RDebugUtils.currentLine=10420225;
 //BA.debugLineNum = 10420225;BA.debugLine="If mEnabled = False Then Return False";
if (__ref._menabled /*boolean*/ ==__c.False) { 
if (true) return __c.False;};
RDebugUtils.currentLine=10420226;
 //BA.debugLineNum = 10420226;BA.debugLine="Dim LeftPanelRightSide As Int = mLeftPanel.Left +";
_leftpanelrightside = (int) (__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft()+__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth());
RDebugUtils.currentLine=10420227;
 //BA.debugLineNum = 10420227;BA.debugLine="If HandlingSwipe = False And x > LeftPanelRightSi";
if (__ref._handlingswipe /*boolean*/ ==__c.False && _x>_leftpanelrightside) { 
RDebugUtils.currentLine=10420228;
 //BA.debugLineNum = 10420228;BA.debugLine="If IsOpen Then";
if (__ref._isopen /*boolean*/ ) { 
RDebugUtils.currentLine=10420229;
 //BA.debugLineNum = 10420229;BA.debugLine="TouchXStart = X";
__ref._touchxstart /*float*/  = _x;
RDebugUtils.currentLine=10420230;
 //BA.debugLineNum = 10420230;BA.debugLine="If Action = mBasePanel.TOUCH_ACTION_UP Then set";
if (_action==__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_UP) { 
__ref._setleftopen /*String*/ (null,__c.False);};
RDebugUtils.currentLine=10420231;
 //BA.debugLineNum = 10420231;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=10420233;
 //BA.debugLineNum = 10420233;BA.debugLine="If IsOpen = False And x > LeftPanelRightSide + E";
if (__ref._isopen /*boolean*/ ==__c.False && _x>_leftpanelrightside+__ref._extrawidth /*int*/ ) { 
RDebugUtils.currentLine=10420234;
 //BA.debugLineNum = 10420234;BA.debugLine="Return False";
if (true) return __c.False;
 };
 };
RDebugUtils.currentLine=10420237;
 //BA.debugLineNum = 10420237;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_MOVE,__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_UP)) {
case 0: {
RDebugUtils.currentLine=10420239;
 //BA.debugLineNum = 10420239;BA.debugLine="Dim dx As Float = x - TouchXStart";
_dx = (float) (_x-__ref._touchxstart /*float*/ );
RDebugUtils.currentLine=10420240;
 //BA.debugLineNum = 10420240;BA.debugLine="TouchXStart = X";
__ref._touchxstart /*float*/  = _x;
RDebugUtils.currentLine=10420241;
 //BA.debugLineNum = 10420241;BA.debugLine="If HandlingSwipe Or Abs(dx) > 3dip Then";
if (__ref._handlingswipe /*boolean*/  || __c.Abs(_dx)>__c.DipToCurrent((int) (3))) { 
RDebugUtils.currentLine=10420242;
 //BA.debugLineNum = 10420242;BA.debugLine="HandlingSwipe = True";
__ref._handlingswipe /*boolean*/  = __c.True;
RDebugUtils.currentLine=10420243;
 //BA.debugLineNum = 10420243;BA.debugLine="ChangeOffset(mLeftPanel.Left + dx, True, False";
__ref._changeoffset /*String*/ (null,(float) (__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft()+_dx),__c.True,__c.False);
 };
 break; }
case 1: {
RDebugUtils.currentLine=10420246;
 //BA.debugLineNum = 10420246;BA.debugLine="If HandlingSwipe Then";
if (__ref._handlingswipe /*boolean*/ ) { 
RDebugUtils.currentLine=10420247;
 //BA.debugLineNum = 10420247;BA.debugLine="ChangeOffset(mLeftPanel.Left, False, False)";
__ref._changeoffset /*String*/ (null,(float) (__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft()),__c.False,__c.False);
 };
RDebugUtils.currentLine=10420249;
 //BA.debugLineNum = 10420249;BA.debugLine="HandlingSwipe = False";
__ref._handlingswipe /*boolean*/  = __c.False;
 break; }
}
;
RDebugUtils.currentLine=10420251;
 //BA.debugLineNum = 10420251;BA.debugLine="Return True";
if (true) return __c.True;
RDebugUtils.currentLine=10420252;
 //BA.debugLineNum = 10420252;BA.debugLine="End Sub";
return false;
}
public String  _setleftopen(b4a.example.b4xdrawer __ref,boolean _b) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "setleftopen", true))
	 {return ((String) Debug.delegate(ba, "setleftopen", new Object[] {_b}));}
float _x = 0f;
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Public Sub setLeftOpen (b As Boolean)";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="If b = IsOpen Then Return";
if (_b==__ref._isopen /*boolean*/ ) { 
if (true) return "";};
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="Dim x As Float";
_x = 0f;
RDebugUtils.currentLine=10813443;
 //BA.debugLineNum = 10813443;BA.debugLine="If b Then x = 0 Else x = -mSideWidth";
if (_b) { 
_x = (float) (0);}
else {
_x = (float) (-__ref._msidewidth /*int*/ );};
RDebugUtils.currentLine=10813444;
 //BA.debugLineNum = 10813444;BA.debugLine="ChangeOffset(x, False, False)";
__ref._changeoffset /*String*/ (null,_x,__c.False,__c.False);
RDebugUtils.currentLine=10813445;
 //BA.debugLineNum = 10813445;BA.debugLine="End Sub";
return "";
}
public String  _changeoffset(b4a.example.b4xdrawer __ref,float _x,boolean _currentlytouching,boolean _noanimation) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "changeoffset", true))
	 {return ((String) Debug.delegate(ba, "changeoffset", new Object[] {_x,_currentlytouching,_noanimation}));}
int _visibleoffset = 0;
int _dx = 0;
int _duration = 0;
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Private Sub ChangeOffset (x As Float, CurrentlyTou";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="x = Max(-mSideWidth, Min(0, x))";
_x = (float) (__c.Max(-__ref._msidewidth /*int*/ ,__c.Min(0,_x)));
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="Dim VisibleOffset As Int = mSideWidth + x";
_visibleoffset = (int) (__ref._msidewidth /*int*/ +_x);
RDebugUtils.currentLine=10551307;
 //BA.debugLineNum = 10551307;BA.debugLine="If CurrentlyTouching = False Then";
if (_currentlytouching==__c.False) { 
RDebugUtils.currentLine=10551308;
 //BA.debugLineNum = 10551308;BA.debugLine="If (IsOpen And VisibleOffset < 0.8 * mSideWidth)";
if ((__ref._isopen /*boolean*/  && _visibleoffset<0.8*__ref._msidewidth /*int*/ ) || (__ref._isopen /*boolean*/ ==__c.False && _visibleoffset<0.2*__ref._msidewidth /*int*/ )) { 
RDebugUtils.currentLine=10551309;
 //BA.debugLineNum = 10551309;BA.debugLine="x = -mSideWidth";
_x = (float) (-__ref._msidewidth /*int*/ );
RDebugUtils.currentLine=10551310;
 //BA.debugLineNum = 10551310;BA.debugLine="SetIsOpen(False)";
__ref._setisopen /*String*/ (null,__c.False);
 }else {
RDebugUtils.currentLine=10551312;
 //BA.debugLineNum = 10551312;BA.debugLine="x = 0";
_x = (float) (0);
RDebugUtils.currentLine=10551313;
 //BA.debugLineNum = 10551313;BA.debugLine="SetIsOpen(True)";
__ref._setisopen /*String*/ (null,__c.True);
 };
RDebugUtils.currentLine=10551315;
 //BA.debugLineNum = 10551315;BA.debugLine="Dim dx As Int = Abs(mLeftPanel.Left - x)";
_dx = (int) (__c.Abs(__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft()-_x));
RDebugUtils.currentLine=10551316;
 //BA.debugLineNum = 10551316;BA.debugLine="Dim duration As Int = Max(0, 200 * dx / mSideWid";
_duration = (int) (__c.Max(0,200*_dx/(double)__ref._msidewidth /*int*/ ));
RDebugUtils.currentLine=10551317;
 //BA.debugLineNum = 10551317;BA.debugLine="If NoAnimation Then duration = 0";
if (_noanimation) { 
_duration = (int) (0);};
RDebugUtils.currentLine=10551318;
 //BA.debugLineNum = 10551318;BA.debugLine="mLeftPanel.SetLayoutAnimated(duration, x, 0, mLe";
__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated(_duration,(int) (_x),(int) (0),__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=10551319;
 //BA.debugLineNum = 10551319;BA.debugLine="mDarkPanel.SetColorAnimated(duration, mDarkPanel";
__ref._mdarkpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetColorAnimated(_duration,__ref._mdarkpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getColor(),__ref._offsettocolor /*int*/ (null,(int) (_x)));
 }else {
RDebugUtils.currentLine=10551329;
 //BA.debugLineNum = 10551329;BA.debugLine="mDarkPanel.Color = OffsetToColor(x)";
__ref._mdarkpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setColor(__ref._offsettocolor /*int*/ (null,(int) (_x)));
RDebugUtils.currentLine=10551330;
 //BA.debugLineNum = 10551330;BA.debugLine="mLeftPanel.Left = x";
__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setLeft((int) (_x));
 };
RDebugUtils.currentLine=10551332;
 //BA.debugLineNum = 10551332;BA.debugLine="End Sub";
return "";
}
public String  _setisopen(b4a.example.b4xdrawer __ref,boolean _newstate) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "setisopen", true))
	 {return ((String) Debug.delegate(ba, "setisopen", new Object[] {_newstate}));}
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Private Sub SetIsOpen (NewState As Boolean)";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="If IsOpen = NewState Then Return";
if (__ref._isopen /*boolean*/ ==_newstate) { 
if (true) return "";};
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="IsOpen = NewState";
__ref._isopen /*boolean*/  = _newstate;
RDebugUtils.currentLine=10616835;
 //BA.debugLineNum = 10616835;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_StateC";
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .SubExists(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_StateChanged",(int) (1))) { 
RDebugUtils.currentLine=10616836;
 //BA.debugLineNum = 10616836;BA.debugLine="CallSubDelayed2(mCallBack,  mEventName & \"_State";
__c.CallSubDelayed2(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_StateChanged",(Object)(__ref._isopen /*boolean*/ ));
 };
RDebugUtils.currentLine=10616838;
 //BA.debugLineNum = 10616838;BA.debugLine="End Sub";
return "";
}
public int  _offsettocolor(b4a.example.b4xdrawer __ref,int _x) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "offsettocolor", true))
	 {return ((Integer) Debug.delegate(ba, "offsettocolor", new Object[] {_x}));}
float _visible = 0f;
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Private Sub OffsetToColor (x As Int) As Int";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="Dim Visible As Float = (mSideWidth + x) / mSideWi";
_visible = (float) ((__ref._msidewidth /*int*/ +_x)/(double)__ref._msidewidth /*int*/ );
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="Return xui.Color_ARGB(100 * Visible, 0, 0, 0)";
if (true) return __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_ARGB((int) (100*_visible),(int) (0),(int) (0),(int) (0));
RDebugUtils.currentLine=10682371;
 //BA.debugLineNum = 10682371;BA.debugLine="End Sub";
return 0;
}
public String  _class_globals(b4a.example.b4xdrawer __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=10223618;
 //BA.debugLineNum = 10223618;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=10223619;
 //BA.debugLineNum = 10223619;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="Private mSideWidth As Int";
_msidewidth = 0;
RDebugUtils.currentLine=10223621;
 //BA.debugLineNum = 10223621;BA.debugLine="Private mLeftPanel As B4XView";
_mleftpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=10223622;
 //BA.debugLineNum = 10223622;BA.debugLine="Private mDarkPanel As B4XView";
_mdarkpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=10223623;
 //BA.debugLineNum = 10223623;BA.debugLine="Private mBasePanel As B4XView";
_mbasepanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=10223624;
 //BA.debugLineNum = 10223624;BA.debugLine="Private mCenterPanel As B4XView";
_mcenterpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=10223625;
 //BA.debugLineNum = 10223625;BA.debugLine="Public ExtraWidth As Int = 50dip";
_extrawidth = __c.DipToCurrent((int) (50));
RDebugUtils.currentLine=10223626;
 //BA.debugLineNum = 10223626;BA.debugLine="Private TouchXStart, TouchYStart As Float 'ignore";
_touchxstart = 0f;
_touchystart = 0f;
RDebugUtils.currentLine=10223627;
 //BA.debugLineNum = 10223627;BA.debugLine="Private IsOpen As Boolean";
_isopen = false;
RDebugUtils.currentLine=10223628;
 //BA.debugLineNum = 10223628;BA.debugLine="Private HandlingSwipe As Boolean";
_handlingswipe = false;
RDebugUtils.currentLine=10223629;
 //BA.debugLineNum = 10223629;BA.debugLine="Private StartAtScrim As Boolean 'ignore";
_startatscrim = false;
RDebugUtils.currentLine=10223630;
 //BA.debugLineNum = 10223630;BA.debugLine="Private mEnabled As Boolean = True";
_menabled = __c.True;
RDebugUtils.currentLine=10223631;
 //BA.debugLineNum = 10223631;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getcenterpanel(b4a.example.b4xdrawer __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "getcenterpanel", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "getcenterpanel", null));}
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Public Sub getCenterPanel As B4XView";
RDebugUtils.currentLine=10944513;
 //BA.debugLineNum = 10944513;BA.debugLine="Return mCenterPanel";
if (true) return __ref._mcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ;
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="End Sub";
return null;
}
public boolean  _getgestureenabled(b4a.example.b4xdrawer __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "getgestureenabled", true))
	 {return ((Boolean) Debug.delegate(ba, "getgestureenabled", null));}
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Public Sub getGestureEnabled As Boolean";
RDebugUtils.currentLine=11075585;
 //BA.debugLineNum = 11075585;BA.debugLine="Return mEnabled";
if (true) return __ref._menabled /*boolean*/ ;
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="End Sub";
return false;
}
public boolean  _getleftopen(b4a.example.b4xdrawer __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "getleftopen", true))
	 {return ((Boolean) Debug.delegate(ba, "getleftopen", null));}
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Public Sub getLeftOpen As Boolean";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="Return IsOpen";
if (true) return __ref._isopen /*boolean*/ ;
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getleftpanel(b4a.example.b4xdrawer __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "getleftpanel", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "getleftpanel", null));}
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Public Sub getLeftPanel As B4XView";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="Return mLeftPanel";
if (true) return __ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ;
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="End Sub";
return null;
}
public String  _initialize(b4a.example.b4xdrawer __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname,anywheresoftware.b4a.objects.B4XViewWrapper _parent,int _sidewidth) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname,_parent,_sidewidth}));}
anywheresoftware.b4a.objects.TouchPanelCreator _creator = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=10289153;
 //BA.debugLineNum = 10289153;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=10289155;
 //BA.debugLineNum = 10289155;BA.debugLine="mSideWidth = SideWidth";
__ref._msidewidth /*int*/  = _sidewidth;
RDebugUtils.currentLine=10289157;
 //BA.debugLineNum = 10289157;BA.debugLine="Dim creator As TouchPanelCreator";
_creator = new anywheresoftware.b4a.objects.TouchPanelCreator();
RDebugUtils.currentLine=10289158;
 //BA.debugLineNum = 10289158;BA.debugLine="mBasePanel = creator.CreateTouchPanel(\"base\")";
__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_creator.CreateTouchPanel(ba,"base").getObject()));
RDebugUtils.currentLine=10289167;
 //BA.debugLineNum = 10289167;BA.debugLine="Parent.AddView(mBasePanel, 0, 0, Parent.Width, Pa";
_parent.AddView((android.view.View)(__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (0),(int) (0),_parent.getWidth(),_parent.getHeight());
RDebugUtils.currentLine=10289168;
 //BA.debugLineNum = 10289168;BA.debugLine="mCenterPanel = xui.CreatePanel(\"\")";
__ref._mcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"");
RDebugUtils.currentLine=10289169;
 //BA.debugLineNum = 10289169;BA.debugLine="mBasePanel.AddView(mCenterPanel, 0, 0, mBasePanel";
__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._mcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=10289170;
 //BA.debugLineNum = 10289170;BA.debugLine="mDarkPanel = xui.CreatePanel(\"dark\")";
__ref._mdarkpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"dark");
RDebugUtils.currentLine=10289171;
 //BA.debugLineNum = 10289171;BA.debugLine="mBasePanel.AddView(mDarkPanel, 0, 0, mBasePanel.W";
__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._mdarkpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=10289172;
 //BA.debugLineNum = 10289172;BA.debugLine="mLeftPanel = xui.CreatePanel(\"LeftPanel\")";
__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"LeftPanel");
RDebugUtils.currentLine=10289173;
 //BA.debugLineNum = 10289173;BA.debugLine="mBasePanel.AddView(mLeftPanel, -SideWidth, 0, Sid";
__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (-_sidewidth),(int) (0),_sidewidth,__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=10289174;
 //BA.debugLineNum = 10289174;BA.debugLine="mLeftPanel.Color = xui.Color_Red";
__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setColor(__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Red);
RDebugUtils.currentLine=10289176;
 //BA.debugLineNum = 10289176;BA.debugLine="Dim p As Panel = mLeftPanel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()));
RDebugUtils.currentLine=10289177;
 //BA.debugLineNum = 10289177;BA.debugLine="p.Elevation = 4dip";
_p.setElevation((float) (__c.DipToCurrent((int) (4))));
RDebugUtils.currentLine=10289191;
 //BA.debugLineNum = 10289191;BA.debugLine="End Sub";
return "";
}
public String  _leftpanel_click(b4a.example.b4xdrawer __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "leftpanel_click", true))
	 {return ((String) Debug.delegate(ba, "leftpanel_click", null));}
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Private Sub LeftPanel_Click";
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="End Sub";
return "";
}
public String  _resize(b4a.example.b4xdrawer __ref,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "resize", true))
	 {return ((String) Debug.delegate(ba, "resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=11010048;
 //BA.debugLineNum = 11010048;BA.debugLine="Public Sub Resize(Width As Int, Height As Int)";
RDebugUtils.currentLine=11010049;
 //BA.debugLineNum = 11010049;BA.debugLine="If IsOpen Then ChangeOffset(-mSideWidth, False, T";
if (__ref._isopen /*boolean*/ ) { 
__ref._changeoffset /*String*/ (null,(float) (-__ref._msidewidth /*int*/ ),__c.False,__c.True);};
RDebugUtils.currentLine=11010050;
 //BA.debugLineNum = 11010050;BA.debugLine="mBasePanel.SetLayoutAnimated(0, 0, 0, Width, Heig";
__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=11010051;
 //BA.debugLineNum = 11010051;BA.debugLine="mLeftPanel.SetLayoutAnimated(0, mLeftPanel.Left,";
__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getLeft(),(int) (0),__ref._mleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbasepanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=11010052;
 //BA.debugLineNum = 11010052;BA.debugLine="mDarkPanel.SetLayoutAnimated(0, 0, 0, Width, Heig";
__ref._mdarkpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=11010053;
 //BA.debugLineNum = 11010053;BA.debugLine="mCenterPanel.SetLayoutAnimated(0, 0, 0, Width, He";
__ref._mcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=11010054;
 //BA.debugLineNum = 11010054;BA.debugLine="End Sub";
return "";
}
public String  _setgestureenabled(b4a.example.b4xdrawer __ref,boolean _b) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xdrawer";
if (Debug.shouldDelegate(ba, "setgestureenabled", true))
	 {return ((String) Debug.delegate(ba, "setgestureenabled", new Object[] {_b}));}
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Public Sub setGestureEnabled (b As Boolean)";
RDebugUtils.currentLine=11141121;
 //BA.debugLineNum = 11141121;BA.debugLine="mEnabled = b";
__ref._menabled /*boolean*/  = _b;
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="End Sub";
return "";
}
}