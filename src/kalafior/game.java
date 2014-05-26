package kalafior;

import java.applet.*; 
import java.awt.*; 
import java.net.*; 
public class game extends java.applet.Applet implements Runnable 
{ 
public Graphics g;
public Thread thread = new Thread(this);
Font font3=new Font("Arial",Font.ITALIC,10);
Font font=new Font("Arial",Font.BOLD,20);
Font font2=new Font("Helvetica",Font.BOLD,30);
Font font1=new Font("Helvetica",Font.BOLD,15);
public boolean stopped,start0;
public int i,j,x,y,mi,oldmi,mj,oldmj,figure,fx1,oldfx,oldfy,fy1,a,movx,movy,best;
public int fx2,fx3,fx4,fy2,fy3,fy4,ff,ful,score,scoretime,level,leveltime,slept,oldscore,th,logtime,ccc,vvv,bbb,nitro;
public int xarr[][],fig[][],figrez[][];
public boolean viewlevel,figgo,ffstop,full,scoreshow,gameover,viewlog,pause;
public Color c1,c2,c3,c4;
boolean start=true,str=true;
String keyName="";
Image backBuffer;
public void init()
{
Graphics g=getGraphics();
thread.start();
stopped=false;
th=1;
ccc=1;
vvv=1;
bbb=0;
nitro=0;
pause=false;
str=false;
logtime=0;
viewlog=true;
start0=true;
viewlevel=false;
figure=61;
figgo=false;
fx1=70;
fy1=6;
full=false;
ful=0;
score=0;
scoretime=0;
scoreshow=false;
level=1;
leveltime=0;
oldscore=0;
slept=100;
gameover=true;
xarr = new int [20][30];
for(int i=0;i<14;i++){
for(int j=0;j<24;j++){
xarr[i][j]=0;
} }
for(int i=0;i<14;i++){
xarr[i][23]=10;}
Color c1= new Color(255,0,0);
Color c2= new Color(200,0,0);
Color c3= new Color(150,0,0);
Color c4= new Color(100,0,0);

} 
public boolean mouseDown(Event evt,int mi,int mj){
if(viewlevel){
viewlog=false;
viewlevel=false;
str=true;
for(int i=0;i<14;i++){
for(int j=0;j<23;j++){
xarr[i][j]=0;
} }}
return true;}
public boolean keyDown(Event evt,int key)
{
if(evt.id==Event.KEY_ACTION)
keyName=getName(evt);
return true;
}
String getName(Event evt)
{
int key = evt.key;
switch(key){
case Event.END:
if(!pause){
pause=true;
return"";}
if(pause){
pause=false;
return"";}
case Event.UP:
if(fx1>=10 && fx1<=120){
figure=figure+1;
if(figure>4 && figure<10) figure=1;
if(figure>10 && figure<20) figure=10;
if(figure>24 && figure<30) figure=21;
if(figure>32 && figure<40) figure=31;
if(figure>42 && figure<50) figure=41;
if(figure>52&& figure<60) figure=51;
if(figure>64 && figure<70) figure=61;
figura();}
return "";
case Event.DOWN:
ffstop=true;
while(ffstop){
przesun(); 
}
return "";
case Event.LEFT:
if(fx1>=10 && fx2>=10 && fx3>=10 && fx4>=10){
if(xarr[fx1/10-1][fy1/10]==0){
if(xarr[fx2/10-1][fy2/10]==0){
if(xarr[fx3/10-1][fy3/10]==0){
if(xarr[fx4/10-1][fy4/10]==0){
fx1=fx1-10;
fx2=fx2-10;
fx3=fx3-10;
fx4=fx4-10;
}}}}}
return "";
case Event.RIGHT:
if(fx1<=120 && fx2<=120 && fx3<=120 && fx4<=120){
if(xarr[fx1/10+1][fy1/10]==0){
if(xarr[fx2/10+1][fy2/10]==0){
if(xarr[fx3/10+1][fy3/10]==0){
if(xarr[fx4/10+1][fy4/10]==0){
fx1=fx1+10;
fx2=fx2+10;
fx3=fx3+10;
fx4=fx4+10;
}}}}}
return "";
default:
int offF1= key - Event.F1;
return "F" + (1+offF1);
}
}
public void figura(){
if(figure==1){
fx3=fx2=fx1;
fx4=fx1-10;
fy2=fy1+10;
fy3=fy1-10;
fy4=fy3;
}
if(figure==2){
fy3=fy2=fy1;
fy4=fy1+10;
fx2=fx1+10;
fx3=fx1-10;
fx4=fx3;
}
if(figure==3){
fx2=fx3=fx1;
fx4=fx1+10;
fy2=fy1-10;
fy3=fy1+10;
fy4=fy3;
}
if(figure==4){
fx2=fx1+10;
fx3=fx1-10;
fx4=fx2;
fy3=fy1;
fy2=fy1;
fy4=fy1-10;
}
if(figure==10){
fx2=fx1;
fx3=fx4=fx1+10;
fy2=fy1+10;
fy4=fy1;
fy3=fy1+10;
}
if(figure==21){
fx3=fx2=fx1;
fx4=fx1+10;
fy2=fy1+10;
fy3=fy1-10;
fy4=fy3;
}
if(figure==22){
fy3=fy2=fy1;
fy4=fy1-10;
fx2=fx1+10;
fx3=fx1-10;
fx4=fx3;
}
if(figure==23){
fx2=fx3=fx1;
fx4=fx1-10;
fy2=fy1-10;
fy3=fy1+10;
fy4=fy3;
}
if(figure==24){
fx2=fx1-10;
fx3=fx1+10;
fx4=fx3;
fy3=fy1;
fy2=fy1;
fy4=fy1+10;
}
if(figure==31){
fx2=fx1-10;
fx3=fx1;
fx4=fx1+10;
fy2=fy1-10;
fy3=fy1-10;
fy4=fy1;
}
if(figure==32){
fx2=fx1+10;
fx3=fx1+10;
fx4=fx1;
fy2=fy1-10;
fy3=fy1;
fy4=fy1+10;
}
if(figure==41){
fx2=fx1+10;
fx3=fx1;
fx4=fx1-10;
fy2=fy1-10;
fy3=fy1-10;
fy4=fy1;
}
if(figure==42){
fx2=fx1-10;
fx3=fx1-10;
fx4=fx1;
fy2=fy1-10;
fy3=fy1;
fy4=fy1+10;
}
if(figure==51){
fx4=fx3=fx2=fx1;
fy2=fy1+10;
fy3=fy4=fy1-10;
}
if(figure==52){
fy4=fy3=fy2=fy1;
fx2=fx1+10;
fx3=fx4=fx1-10;
}
if(figure==61){
fy3=fy2=fy1;
fy4=fy1-10;
fx3=fx1-10;
fx2=fx1+10;
fx4=fx1;
}
if(figure==62){
fy3=fy1+10;
fy2=fy1-10;
fy4=fy1;
fx3=fx2=fx1;
fx4=fx1-10;
}
if(figure==63){
fy3=fy2=fy1;
fy4=fy1+10;
fx3=fx1-10;
fx2=fx1+10;
fx4=fx1;
}
if(figure==64){
fy3=fy1+10;
fy2=fy1-10;
fy4=fy1;
fx3=fx2=fx1;
fx4=fx1+10;
}
}
public void choose(){
figure = (int) (Math.random()*7);
if(figure==0)figure=51;
if(figure==1)figure=1;
if(figure==2)figure=10;
if(figure==3)figure=21;
if(figure==4)figure=31;
if(figure==6)figure=41;
if(figure==5)figure=61;
if(figure==7)figure=41;
fy1=10;
fx1=70;
figura();
}
public void przesun(){
if(!pause)
fy1=fy1+2+nitro;
figura();
if(xarr[fx1/10][fy1/10+1]>0){
xarr[fx1/10][fy1/10]=10;
xarr[fx2/10][fy2/10]=10;
xarr[fx3/10][fy3/10]=10;
xarr[fx4/10][fy4/10]=10;
ffstop=false;
sprawdz1();
choose();
}
figura();
if(xarr[fx2/10][fy2/10+1]>0){
xarr[fx1/10][fy1/10]=10;
xarr[fx2/10][fy2/10]=10;
xarr[fx3/10][fy3/10]=10;
xarr[fx4/10][fy4/10]=10;
ffstop=false;
sprawdz1();
choose();
}
figura();
if(xarr[fx3/10][fy3/10+1]>0){
xarr[fx1/10][fy1/10]=10;
xarr[fx2/10][fy2/10]=10;
xarr[fx3/10][fy3/10]=10;
xarr[fx4/10][fy4/10]=10;
ffstop=false;
sprawdz1();
choose();
}
figura();
if(xarr[fx4/10][fy4/10+1]>0){
xarr[fx1/10][fy1/10]=10;
xarr[fx2/10][fy2/10]=10;
xarr[fx3/10][fy3/10]=10;
xarr[fx4/10][fy4/10]=10;
ffstop=false;
sprawdz1();
choose();
}
figura(); 
}
public void sprawdz1(){
for(int mj=0;mj<3;mj++){ 
for(int i=22;i>0;i--){
if(xarr[0][i]>0 &&
xarr[1][i]>0 &&
xarr[2][i]>0 &&
xarr[3][i]>0 &&
xarr[4][i]>0 &&
xarr[5][i]>0 &&
xarr[6][i]>0 &&
xarr[7][i]>0 &&
xarr[8][i]>0 &&
xarr[9][i]>0 &&
xarr[10][i]>0 &&
xarr[11][i]>0 &&
xarr[12][i]>0 &&
xarr[13][i]>0){
for(int mi=0;mi<14;mi++){
xarr[mi][i]=0;}
ful=i;
obsun();
}
}
}
for(int q=0;q<14;q++){
if(xarr[q][2]>0)
gameover=true;
logtime=0;
str=false;}
}
public void obsun(){
score=score+100;
if(score>best)
best=score;
scoreshow=true;
scoretime=0;
if(score==oldscore+1000){
oldscore=score;
if(slept>30)
slept=slept-20;
nitro=nitro+1;
level=level+1;
leveltime=0;
viewlevel=true;
}
for(int i=ful;i>1;i--){
for(int j=0;j<14;j++){
xarr[j][i]=xarr[j][i-1];
}}
}
public void sprawdz(){
if(keyName=="l"){
if(xarr[fx1-1][fy1]==0)
fx1=fx1-10;}
else
fx1=fx1;
if(keyName=="r"){
if(xarr[fx1+1][fy1]==0)
fx1=fx1+10;}
else
fx1=fx1;
}
public void wybierz(){
figgo=true;
}
public void restart(){
if(!str){
viewlevel=true;
scoreshow=true;
leveltime=0;
scoretime=0;
}
else{
stopped=false;
start0=true;
nitro=0;
viewlevel=true;
figure=51;
figgo=false;
fx1=100;
fy1=6;
full=false;
ful=0;
logtime=0;
viewlog=false;
pause=false;
score=0;
scoretime=0;
scoreshow=false;
level=1;
leveltime=0;
oldscore=0;
slept=100;
gameover=false;
xarr = new int [20][30];
for(int i=0;i<14;i++){
for(int j=0;j<24;j++){
xarr[i][j]=0;
} }
for(int i=0;i<14;i++){
xarr[i][23]=10;}
}
}
public void run()
{ while(start){
sprawdz();
if(!viewlevel)
przesun();
figura();
if(gameover)
restart();
backBuffer = createImage(200,300);
Graphics g = backBuffer.getGraphics();
paint(g);
g=getGraphics();
g.drawImage(backBuffer,0,0,this);
try {
Thread.currentThread().sleep(50);
// start();
// repaint();
//stop();
} catch(InterruptedException e) {
thread.stop();
}
catch(NullPointerException e) {
thread.stop();
}
}}
public void paint(Graphics g){
setBackground(Color.white);
c3= new Color(150,150,150);
for(int i=0;i<14;i++){
for(int j=0;j<24;j++){
if(xarr[i][j]>0){
x=(i*10)+5;
y=j*10;
g.setColor(Color.black);
g.fillPolygon(
new int[] {x,x,x+10,x+10},
new int[] {y,y+10,y+10,y},
4
);
g.setColor(Color.blue);
g.fillPolygon(
new int[] {x+1,x+1,x+9,x+9},
new int[] {y+1,y+9,y+9,y+1},
4
);
}}}
g.setColor(c3);
g.drawLine(4,0,4,240);
g.drawLine(4,240,145,240);
g.drawLine(145,240,145,0);
if(viewlevel){
g.setColor(Color.blue);
g.fillPolygon(
new int[] {10,140,140,10},
new int[] {50,50,150,150},
4
);
}
else{
g.setColor(Color.black);
g.fillPolygon(
new int[] {70,70,30},
new int[] {250,270,260},
3
);
g.setColor(Color.black);
g.fillPolygon(
new int[] {80,100,120},
new int[] {270,250,270},
3
);
g.setColor(Color.black);
g.fillPolygon(
new int[] {80,100,120},
new int[] {275,290,275},
3
);
g.setColor(Color.black);
g.fillPolygon(
new int[] {130,130,170},
new int[] {250,270,260},
3
);
g.setColor(Color.black);
g.fillPolygon(
new int[] {fx1+5,fx1+15,fx1+15,fx1+5},
new int[] {fy1,fy1,fy1+10,fy1+10},
4
);
///
g.setColor(Color.black);
g.fillPolygon(
new int[] {fx2+5,fx2+15,fx2+15,fx2+5},
new int[] {fy2,fy2,fy2+10,fy2+10},
4
);
///
g.setColor(Color.black);
g.fillPolygon(
new int[] {fx4+5,fx4+15,fx4+15,fx4+5},
new int[] {fy4,fy4,fy4+10,fy4+10},
4
);
///
g.setColor(Color.black);
g.fillPolygon(
new int[] {fx3+5,fx3+15,fx3+15,fx3+5},
new int[] {fy3,fy3,fy3+10,fy3+10},
4
);}
//
if(scoreshow && scoretime<30){
g.setColor(c3);
g.setFont(font);
if(score<1000)
g.drawString(""+score+" punktów",15,100);
if(score>1000)
g.drawString(""+score+" punktów",10,100);
scoretime=scoretime+1;
}
if(viewlevel && leveltime<30){
g.setFont(font);
g.setColor(c3);

leveltime=leveltime+1;
}
else viewlevel=false;
if(gameover){
g.drawString("Game Over",20,75);
logtime=logtime+1;
if(logtime>100)
viewlog=true;
}
if(viewlog){
g.setColor(Color.black);
g.fillPolygon(
new int[] {10,140,140,10},
new int[] {50,50,150,150},
4
);
g.setColor(Color.blue);
g.fillPolygon(
new int[] {12,138,138,12},
new int[] {52,52,148,148},
4
);
c2= new Color(vvv,vvv,vvv);
vvv=vvv-5;
if(vvv<5)vvv=250;
g.setColor(c2);
g.setFont(font2);
g.drawString("Tetris",13,100);
c1= new Color(ccc,ccc,ccc);
ccc=ccc+5;
if(ccc>250)ccc=1;
g.setColor(c1);
g.setFont(font1);

}
g.setColor(c3);
g.setFont(font3);
g.drawString("Najlepszy "+best,10,10); 
if(pause){
g.setFont(font);
g.setColor(c3);
g.drawString("PAUZA ",40,100);
}
}}
