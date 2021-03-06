/**
 * Copyright (c) 2013, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 **/

package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.jaxb.ActivationIntervals;
import edu.berkeley.path.model_objects.jaxb.Interval;


import java.util.ArrayList;
import java.util.List;

/**
 * Model Object Controller Set class.
 *
 * @author mnjuhn
 */
public class Controller extends edu.berkeley.path.model_objects.jaxb.Controller {

  /**
   * Check to make sure all controller is valid
   *
   * @return boolean
   */
  public boolean isValid() {
    // TODO: implement validation logic
    return true;
  }

  /**
   * @param id the id to set
   */
  @Override
  public void setId(long id) {
    super.setId(id);
  }

  /**
   * @return the id
   */
  @Override
  public long getId() {
    return super.getId();
  }

  /**
   * @param name the name to set
   */
  @Override
  public void setName(String name) {
    super.setName(name);
  }

  /**
   * @return the name
   */
  @Override
  public String getName() {
    return super.getName();
  }

  /**
   * @param modstamp the modstamp to set
   */
  @Override
  public void setModStamp(String modstamp) {
    super.setModStamp(modstamp);
  }


  /**
   * @return the modStamp
   */
  @Override
  public String getModStamp() {
    return super.getModStamp();
  }

  /**
   * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @return CRUD Flag enumeration
   */
  public CrudFlag getCrudFlagEnum() {

    CrudFlag flag = null;
    // Check if CRUDFlag is null, if so return NONE enumeration
    if (super.getCrudFlag() == null) {
      setCrudFlagEnum(CrudFlag.NONE);
      flag = CrudFlag.NONE;
    }
    else {
      switch (CrudFlag.valueOf(super.getCrudFlag())) {
        case CREATE:
          flag = CrudFlag.CREATE;
          break;
        case RETRIEVE:
          flag = CrudFlag.RETRIEVE;
          break;
        case UPDATE:
          flag = CrudFlag.UPDATE;
          break;
        case DELETE:
          flag = CrudFlag.DELETE;
          break;
        default:
          flag = CrudFlag.NONE;
          break;

      }
    }
    return flag;
  }

  /**
   * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @param CRUD Flag enumeration
   */
  public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
    // Check if CRUDFlag is null, if so return NONE enumeration
    if (flag == null) {
      super.setCrudFlag("NONE");
    }
    else {
      switch (flag) {
        case CREATE:
          super.setCrudFlag("CREATE");
          break;
        case RETRIEVE:
          super.setCrudFlag("RETRIEVE");
          break;
        case UPDATE:
          super.setCrudFlag("UPDATE");
          break;
        case DELETE:
          super.setCrudFlag("DELETE");
          break;
        default:
          super.setCrudFlag("NONE");
          break;

      }
    }
  }

  /**
   * Get Controller Type for this object
   *
   * @return ControllerType  An object representing the the id, name, and
   * description for this ScenarioElementType
   */
  @Override
  public edu.berkeley.path.model_objects.jaxb.ControllerType getControllerType() {
    return super.getControllerType();
  }

  /**
   * Convenience method for users to get Controller Type Id directly
   *
   * @return Integer The id of the Controller Type
   */
  public Integer getControllerTypeId() {
    if (getControllerType() != null) {
      return getControllerType().getId();
    }
    else {
      return null;
    }
  }

  /**
   * Set the Controller Type for this object based on the parameters passed in.
   *
   * @param typeId Id of the ControllerType
   * @param name Name of the ControllerType
   * @param desc Description of the ControllerType
   */
  public void setControllerType(Integer typeId, String name, String desc) {
    edu.berkeley.path.model_objects.jaxb.ControllerType type =
        new edu.berkeley.path.model_objects.jaxb.ControllerType();
    type.setId(typeId);
    type.setName(name);
    type.setDescription(desc);
    super.setControllerType(type);
  }

  /**
   * Get Activation Start time
   *
   * @returns the activation start time in seconds
   */
  public Double getActivationStartTime () {
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      return getActivationIntervals().getInterval().get(0).getStartTime();
    }
    else {
      return null;
    }
  }

  /**
   * Set Activation Start time
   *
   * @param Activation start time in seconds
   */
  public void setActivationStartTime (Double seconds) {
    // If the activation interval exists, change start time
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      // get the existing activation interval and set it's start time
      getActivationIntervals().getInterval().get(0).setStartTime(seconds);

    } else {
      // otherwise create new interval
      Interval interval = new Interval();
      interval.setStartTime(seconds);
      ActivationIntervals activationIntervals = new ActivationIntervals();
      activationIntervals.getInterval().add(interval);
      setActivationIntervals(activationIntervals);
    }

  }

  /**
   * Get Activation End time
   *
   * @returns the activation end time in seconds
   */
  public Double getActivationEndTime () {
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      return getActivationIntervals().getInterval().get(0).getEndTime();
    }
    else {
      return null;
    }
  }

  /**
   * Set Activation end time
   *
   * @param Activation end time in seconds
   */
  public void setActivationEndTime (Double seconds) {
    // If the activation interval exists, change end time
    if (getActivationIntervals() != null &&
        getActivationIntervals().getInterval() != null &&
        getActivationIntervals().getInterval().size() > 0) {
      // get the existing activation interval and set it's end time
      getActivationIntervals().getInterval().get(0).setEndTime(seconds);

    } else {
      // otherwise create new interval
      Interval interval = new Interval();
      interval.setEndTime(seconds);
      ActivationIntervals activationIntervals = new ActivationIntervals();
      activationIntervals.getInterval().add(interval);
      setActivationIntervals(activationIntervals);
    }

  }

  /**
   * Get Sensor Set associated with this controller.
   *
   * @return Sensor Set Model Object.
   */
  @SuppressWarnings("unchecked")
  public SensorSet getSensorSet() {
    edu.berkeley.path.model_objects.jaxb.SensorSet sensorSet = getSensorSet();

    // cast sensor
    return (SensorSet) sensorSet;
  }

  /**
   * Set Sensor Set associated with this controller.
   *
   * @param set Sensor Set Model Object.
   */
  @SuppressWarnings("unchecked")
  public void setSensorSet(SensorSet set) {
    setSensorSet(set);
  }


  /**
   * Get Actuator Set associated with this controller.
   *
   * @return Actuator Set Model Object.
   */
  @SuppressWarnings("unchecked")
  public ActuatorSet getActuatorSet() {
    edu.berkeley.path.model_objects.jaxb.ActuatorSet actuatorSet = getActuatorSet();

    // cast sensor
    return (ActuatorSet) actuatorSet;
  }

  /**
   * Set Actuator Set associated with this controller.
   *
   * @param set Actuator Set Model Object.
   */
  @SuppressWarnings("unchecked")
  public void setActuatorSet(ActuatorSet set) {
    setActuatorSet(set);
  }


  /**
   * Get Parameters
   *
   * @return Parameters the parameters associated with this actuator
   */
  @Override
  public edu.berkeley.path.model_objects.shared.Parameters getParameters() {
    return (edu.berkeley.path.model_objects.shared.Parameters)super.getParameters();
  }


  /**
   * @param Parameters the parameters to set the actuator
   */
  public void setParameters(edu.berkeley.path.model_objects.shared.Parameters parameters) {
    super.setParameters(parameters);
  }


}
