package com.cddzmitry;

public class PC {
//    composition used for multible classes to inherit from!!
//    this is amazing !
    private Case theCase;
    private Monitor monitor;
    private  Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }
    public  void powerUp(){
//        but we can still call private methods within the class
        theCase.pressButtom();
        drawLogo();
    }
    private void drawLogo() {
//        Fancy graphic

//        getMonitor().drawPixelAt(1200,50,"yellow");
//        or
        monitor.drawPixelAt(1200, 50, "yellow");
    }

}
