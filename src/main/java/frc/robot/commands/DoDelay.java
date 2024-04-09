/* package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DoDelay extends Command {

private double expireTime;
private double timeout;
private Supplier<Double> startTime;


    public DoDelay(double seconds, Supplier<Double> startTime) {
    this.timeout = seconds;
    this.startTime = startTime;
    
    addRequirements();
    } 

    protected void startTimer() {
    expireTime = startTime.get() + timeout;
    }

    @Override
    public void initialize() {
    startTimer();
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("Delay finished at: " + Timer.getFPGATimestamp());
        }
    }

    @Override
    public boolean isFinished() {
    return (startTime.get() >= expireTime);
    }
}
*/