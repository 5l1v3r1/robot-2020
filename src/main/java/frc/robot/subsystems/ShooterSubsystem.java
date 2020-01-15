/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  private final WPI_VictorSPX shooterMotor = new WPI_VictorSPX(ShooterConstants.shooterMotorPort);
  public final Encoder shooterEncoder = new Encoder(ShooterConstants.shooterEncoderA, ShooterConstants.shooterEncoderB,
      ShooterConstants.shooterEncoderIsReversed);

  public ShooterSubsystem() {
    shooterEncoder.setDistancePerPulse(1.0 / (ShooterConstants.shooterEncoderPPR / 4));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(double val) {
    // shooterMotor.set(val);
    shooterMotor.setVoltage(val);
  }

  public double getRPM() {
    return shooterEncoder.getRate() * 60;
  }
}