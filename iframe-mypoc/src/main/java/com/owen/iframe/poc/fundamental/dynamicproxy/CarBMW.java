package com.owen.iframe.poc.fundamental.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarBMW implements IVehicle{
    @Override
    public void run() {
      log.info("...Running...");
    }
}
