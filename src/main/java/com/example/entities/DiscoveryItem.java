package com.example.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class DiscoveryItem {
    private Map<String, Object> fieldToValue = new HashMap<String, Object>();

    public Map<String, Object> getFieldToValue() {
        return null;
    }

    public Set<String> getAllKeys() {
        return fieldToValue.keySet();
    }

    public void setValueToField(String fieldName, Object value) {
        try {
            fieldToValue.put(fieldName, new Double(Double.parseDouble(value.toString())));
        } catch (NumberFormatException ex) {
            fieldToValue.put(fieldName, value);
        }
    }

    public Object getValueFromField(String fieldName) {
        return fieldToValue.get(fieldName);
    }

    public void setFieldToValue(Map<String, Object> fieldToValue) {
        this.fieldToValue = fieldToValue;
    }

    public LocalDate getDate() {
        return (LocalDate)fieldToValue.get("date");
    }

    public void setDate(Date date) {
        fieldToValue.put("date", date);
    }

    public LocalTime getTime() {
        return (LocalTime)fieldToValue.get("time");
    }

    public void setTime(LocalTime time) {
        fieldToValue.put("time", time);
    }

    public Integer getDayOfYear() {
        return (Integer)fieldToValue.get("dayOfYear");
    }

    public void setDayOfYear(Integer dayOfYear) {
        fieldToValue.put("dayOfYear", dayOfYear);
    }

    public Double getDayOfYearFraction() {
        return (Double)fieldToValue.get("dayOfYearFraction");
    }

    public void setDayOfYearFraction(Double dayOfYearFraction) {
        fieldToValue.put("dayOfYearFraction", dayOfYearFraction);
    }

    public Double getAod1640nm() {
        return (Double)fieldToValue.get("aod1640nm");
    }

    public void setAod1640nm(Double aod1640nm) {
        fieldToValue.put("aod1640nm", aod1640nm);
    }

    public Double getAod1020() {
        return (Double)fieldToValue.get("aod1020");
    }

    public void setAod1020(Double aod1020) {
        fieldToValue.put("aod1020", aod1020);
    }

    public Double getAod870() {
        return (Double)fieldToValue.get("aod870");
    }

    public void setAod870(Double aod870) {
        fieldToValue.put("aod870", aod870);
    }

    public Double getAod865() {
        return (Double)fieldToValue.get("aod865");
    }

    public void setAod865(Double aod865) {
        fieldToValue.put("aod865", aod865);
    }

    public Double getAod779() {
        return (Double)fieldToValue.get("aod779");
    }

    public void setAod779(Double aod779) {
        fieldToValue.put("aod779", aod779);
    }

    public Double getAod675() {
        return (Double)fieldToValue.get("aod675");
    }

    public void setAod675(Double aod675) {
        fieldToValue.put("aod675", aod675);
    }

    public Double getAod667() {
        return (Double)fieldToValue.get("aod667");
    }

    public void setAod667(Double aod667) {
        fieldToValue.put("aod667", aod667);
    }

    public Double getAod620() {
        return (Double)fieldToValue.get("aod620");
    }

    public void setAod620(Double aod620) {
        fieldToValue.put("aod620", aod620);
    }

    public Double getAod560() {
        return (Double)fieldToValue.get("aod560");
    }

    public void setAod560(Double aod560) {
        fieldToValue.put("aod560", aod560);
    }

    public Double getAod555() {
        return (Double)fieldToValue.get("aod555");
    }

    public void setAod555(Double aod555) {
        fieldToValue.put("aod555", aod555);
    }

    public Double getAod551() {
        return (Double)fieldToValue.get("aod551");
    }

    public void setAod551(Double aod551) {
        fieldToValue.put("aod551", aod551);
    }

    public Double getAod532() {
        return (Double)fieldToValue.get("aod532");
    }

    public void setAod532(Double aod532) {
        fieldToValue.put("aod532", aod532);
    }

    public Double getAod531() {
        return (Double)fieldToValue.get("aod531");
    }

    public void setAod531(Double aod531) {
        fieldToValue.put("aod531", aod531);
    }

    public Double getAod510() {
        return (Double)fieldToValue.get("aod510");
    }

    public void setAod510(Double aod510) {
        fieldToValue.put("aod510", aod510);
    }

    public Double getAod500() {
        return (Double)fieldToValue.get("aod500");
    }

    public void setAod500(Double aod500) {
        fieldToValue.put("aod500", aod500);
    }

    public Double getAod490() {
        return (Double)fieldToValue.get("aod490");
    }

    public void setAod490(Double aod490) {
        fieldToValue.put("aod490", aod490);
    }

    public Double getAod443() {
        return (Double)fieldToValue.get("aod443");
    }

    public void setAod443(Double aod443) {
        fieldToValue.put("aod443", aod443);
    }

    public Double getAod440() {
        return (Double)fieldToValue.get("aod440");
    }

    public void setAod440(Double aod440) {
        fieldToValue.put("aod440", aod440);
    }

    public Double getAod412() {
        return (Double)fieldToValue.get("aod412");
    }

    public void setAod412(Double aod412) {
        fieldToValue.put("aod412", aod412);
    }

    public Double getAod400() {
        return (Double)fieldToValue.get("aod400");
    }

    public void setAod400(Double aod400) {
        fieldToValue.put("aod400", aod400);
    }

    public Double getAod380() {
        return (Double)fieldToValue.get("aod380");
    }

    public void setAod380(Double aod380) {
        fieldToValue.put("aod380", aod380);
    }

    public Double getAod340() {
        return (Double)fieldToValue.get("aod340");
    }

    public void setAod340(Double aod340) {
        fieldToValue.put("aod340", aod340);
    }

    public Double getPrecipitablwWater() {
        return (Double)fieldToValue.get("precipitablwWater");
    }

    public void setPrecipitablwWater(Double precipitablwWater) {
        fieldToValue.put("precipitablwWater", precipitablwWater);
    }

    public Double getAod681() {
        return (Double)fieldToValue.get("aod681");
    }

    public void setAod681(Double aod681) {
        fieldToValue.put("aod681", aod681);
    }

    public Double getAod709() {
        return (Double)fieldToValue.get("aod709");
    }

    public void setAod709(Double aod709) {
        fieldToValue.put("aod709", aod709);
    }

    public Double getAodEmpty1() {
        return (Double)fieldToValue.get("aodEmpty1");
    }

    public void setAodEmpty1(Double aodEmpty1) {
        fieldToValue.put("aodEmpty1", aodEmpty1);
    }

    public Double getAodEmpty2() {
        return (Double)fieldToValue.get("aodEmpty2");
    }

    public void setAodEmpty2(Double aodEmpty2) {
        fieldToValue.put("aodEmpty2", aodEmpty2);
    }

    public Double getAodEmpty3() {
        return (Double)fieldToValue.get("aodEmpty3");
    }

    public void setAodEmpty3(Double aodEmpty3) {
        fieldToValue.put("aodEmpty3", aodEmpty3);
    }

    public Double getAodEmpty4() {
        return (Double)fieldToValue.get("aodEmpty4");
    }

    public void setAodEmpty4(Double aodEmpty4) {
        fieldToValue.put("aodEmpty4", aodEmpty4);
    }

    public Double getAodEmpty5() {
        return (Double)fieldToValue.get("aodEmpty5");
    }

    public void setAodEmpty5(Double aodEmpty5) {
        fieldToValue.put("aodEmpty5", aodEmpty5);
    }

    public Double getAodEmpty6() {
        return (Double)fieldToValue.get("aodEmpty6");
    }

    public void setAodEmpty6(Double aodEmpty6) {
        fieldToValue.put("aodEmpty6", aodEmpty6);
    }

    public Double getTripletVariability1640() {
        return (Double)fieldToValue.get("tripletVariability1640");
    }

    public void setTripletVariability1640(Double tripletVariability1640) {
        fieldToValue.put("tripletVariability1640", tripletVariability1640);
    }

    public Double getTripletVariability1020() {
        return (Double)fieldToValue.get("tripletVariability1020");
    }

    public void setTripletVariability1020(Double tripletVariability1020) {
        fieldToValue.put("tripletVariability1020", tripletVariability1020);
    }

    public Double getTripletVariability870() {
        return (Double)fieldToValue.get("tripletVariability870");
    }

    public void setTripletVariability870(Double tripletVariability870) {
        fieldToValue.put("tripletVariability870", tripletVariability870);
    }

    public Double getTripletVariability865() {
        return (Double)fieldToValue.get("tripletVariability865");
    }

    public void setTripletVariability865(Double tripletVariability865) {
        fieldToValue.put("tripletVariability865", tripletVariability865);
    }

    public Double getTripletVariability779() {
        return (Double)fieldToValue.get("tripletVariability779");
    }

    public void setTripletVariability779(Double tripletVariability779) {
        fieldToValue.put("tripletVariability779", tripletVariability779);
    }

    public Double getTripletVariability675() {
        return (Double)fieldToValue.get("tripletVariability675");
    }

    public void setTripletVariability675(Double tripletVariability675) {
        fieldToValue.put("tripletVariability675", tripletVariability675);
    }

    public Double getTripletVariability667() {
        return (Double)fieldToValue.get("tripletVariability667");
    }

    public void setTripletVariability667(Double tripletVariability667) {
        fieldToValue.put("tripletVariability667", tripletVariability667);
    }

    public Double getTripletVariability620() {
        return (Double)fieldToValue.get("tripletVariability620");
    }

    public void setTripletVariability620(Double tripletVariability620) {
        fieldToValue.put("tripletVariability620", tripletVariability620);
    }

    public Double getTripletVariability560() {
        return (Double)fieldToValue.get("tripletVariability560");
    }

    public void setTripletVariability560(Double tripletVariability560) {
        fieldToValue.put("tripletVariability560", tripletVariability560);
    }

    public Double getTripletVariability555() {
        return (Double)fieldToValue.get("tripletVariability555");
    }

    public void setTripletVariability555(Double tripletVariability555) {
        fieldToValue.put("tripletVariability555", tripletVariability555);
    }

    public Double getTripletVariability551() {
        return (Double)fieldToValue.get("tripletVariability551");
    }

    public void setTripletVariability551(Double tripletVariability551) {
        fieldToValue.put("tripletVariability551", tripletVariability551);
    }

    public Double getTripletVariability532() {
        return (Double)fieldToValue.get("tripletVariability532");
    }

    public void setTripletVariability532(Double tripletVariability532) {
        fieldToValue.put("tripletVariability532", tripletVariability532);
    }

    public Double getTripletVariability531() {
        return (Double)fieldToValue.get("tripletVariability531");
    }

    public void setTripletVariability531(Double tripletVariability531) {
        fieldToValue.put("tripletVariability531", tripletVariability531);
    }

    public Double getTripletVariability510() {
        return (Double)fieldToValue.get("tripletVariability510");
    }

    public void setTripletVariability510(Double tripletVariability510) {
        fieldToValue.put("tripletVariability510", tripletVariability510);
    }

    public Double getTripletVariability500() {
        return (Double)fieldToValue.get("tripletVariability500");
    }

    public void setTripletVariability500(Double tripletVariability500) {
        fieldToValue.put("tripletVariability500", tripletVariability500);
    }

    public Double getTripletVariability490() {
        return (Double)fieldToValue.get("tripletVariability490");
    }

    public void setTripletVariability490(Double tripletVariability490) {
        fieldToValue.put("tripletVariability490", tripletVariability490);
    }

    public Double getTripletVariability443() {
        return (Double)fieldToValue.get("tripletVariability443");
    }

    public void setTripletVariability443(Double tripletVariability443) {
        fieldToValue.put("tripletVariability443", tripletVariability443);
    }

    public Double getTripletVariability440() {
        return (Double)fieldToValue.get("tripletVariability440");
    }

    public void setTripletVariability440(Double tripletVariability440) {
        fieldToValue.put("tripletVariability440", tripletVariability440);
    }

    public Double getTripletVariability412() {
        return (Double)fieldToValue.get("tripletVariability412");
    }

    public void setTripletVariability412(Double tripletVariability412) {
        fieldToValue.put("tripletVariability412", tripletVariability412);
    }

    public Double getTripletVariability400() {
        return (Double)fieldToValue.get("tripletVariability400");
    }

    public void setTripletVariability400(Double tripletVariability400) {
        fieldToValue.put("tripletVariability400", tripletVariability400);
    }

    public Double getTripletVariability380() {
        return (Double)fieldToValue.get("tripletVariability380");
    }

    public void setTripletVariability380(Double tripletVariability380) {
        fieldToValue.put("tripletVariability380", tripletVariability380);
    }

    public Double getTripletVariability340() {
        return (Double)fieldToValue.get("tripletVariability340");
    }

    public void setTripletVariability340(Double tripletVariability340) {
        fieldToValue.put("tripletVariability340", tripletVariability340);
    }

    public Double getTripletVariabilityPreciptibleWater() {
        return (Double)fieldToValue.get("tripletVariabilityPreciptibleWater");
    }

    public void setTripletVariabilityPreciptibleWater(Double tripletVariabilityPreciptibleWater) {
        fieldToValue.put("tripletVariabilityPreciptibleWater", tripletVariabilityPreciptibleWater);
    }

    public Double getTripletVariability681() {
        return (Double)fieldToValue.get("tripletVariability681");
    }

    public void setTripletVariability681(Double tripletVariability681) {
        fieldToValue.put("tripletVariability681", tripletVariability681);
    }

    public Double getTripletVariability709() {
        return (Double)fieldToValue.get("tripletVariability709");
    }

    public void setTripletVariability709(Double tripletVariability709) {
        fieldToValue.put("tripletVariability709", tripletVariability709);
    }

    public Double getTripletVariabilityEmpty1() {
        return (Double)fieldToValue.get("tripletVariabilityEmpty1");
    }

    public void setTripletVariabilityEmpty1(Double tripletVariabilityEmpty1) {
        fieldToValue.put("tripletVariabilityEmpty1", tripletVariabilityEmpty1);
    }

    public Double getTripletVariabilityEmpty2() {
        return (Double)fieldToValue.get("tripletVariabilityEmpty2");
    }

    public void setTripletVariabilityEmpty2(Double tripletVariabilityEmpty2) {
        fieldToValue.put("tripletVariabilityEmpty2", tripletVariabilityEmpty2);
    }

    public Double getTripletVariabilityEmpty3() {
        return (Double)fieldToValue.get("tripletVariabilityEmpty3");
    }

    public void setTripletVariabilityEmpty3(Double tripletVariabilityEmpty3) {
        fieldToValue.put("tripletVariabilityEmpty3", tripletVariabilityEmpty3);
    }

    public Double getTripletVariabilityEmpty4() {
        return (Double)fieldToValue.get("tripletVariabilityEmpty4");
    }

    public void setTripletVariabilityEmpty4(Double tripletVariabilityEmpty4) {
        fieldToValue.put("tripletVariabilityEmpty4", tripletVariabilityEmpty4);
    }

    public Double getTripletVariabilityEmpty5() {
        return (Double)fieldToValue.get("tripletVariabilityEmpty5");
    }

    public void setTripletVariabilityEmpty5(Double tripletVariabilityEmpty5) {
        fieldToValue.put("tripletVariabilityEmpty5", tripletVariabilityEmpty5);
    }

    public Double getTripletVariabilityEmpty6() {
        return (Double)fieldToValue.get("tripletVariabilityEmpty6");
    }

    public void setTripletVariabilityEmpty6(Double tripletVariabilityEmpty6) {
        fieldToValue.put("tripletVariabilityEmpty6", tripletVariabilityEmpty6);
    }

    public Double getAngstormExponent440_870() {
        return (Double)fieldToValue.get("angstormExponent440_870");
    }

    public void setAngstormExponent440_870(Double angstormExponent440_870) {
        fieldToValue.put("angstormExponent440_870", angstormExponent440_870);
    }

    public Double getAngstormExponent380_500() {
        return (Double)fieldToValue.get("angstormExponent380_500");
    }

    public void setAngstormExponent380_500(Double angstormExponent380_500) {
        fieldToValue.put("angstormExponent380_500", angstormExponent380_500);
    }

    public Double getAngstormExponent440_657() {
        return (Double)fieldToValue.get("angstormExponent440_657");
    }

    public void setAngstormExponent440_657(Double angstormExponent440_657) {
        fieldToValue.put("angstormExponent440_657", angstormExponent440_657);
    }

    public Double getAngstormExponent500_870() {
        return (Double)fieldToValue.get("angstormExponent500_870");
    }

    public void setAngstormExponent500_870(Double angstormExponent500_870) {
        fieldToValue.put("angstormExponent500_870", angstormExponent500_870);
    }

    public Double getAngstormExponent340_440() {
        return (Double)fieldToValue.get("angstormExponent340_440");
    }

    public void setAngstormExponent340_440(Double angstormExponent340_440) {
        fieldToValue.put("angstormExponent340_440", angstormExponent340_440);
    }

    public Double getAngstormExponentPolar440_675() {
        return (Double)fieldToValue.get("angstormExponentPolar440_675");
    }

    public void setAngstormExponentPolar440_675(Double angstormExponentPolar440_675) {
        fieldToValue.put("angstormExponentPolar440_675", angstormExponentPolar440_675);
    }

    public String getDataQualityLevel() {
        return  (String)fieldToValue.get("dataQualityLevel");
    }

    public void setDataQualityLevel(String dataQualityLevel) {
        fieldToValue.put("dataQualityLevel", dataQualityLevel);
    }

    public Integer getAeronetIstrumentNumber() {
        return (Integer)fieldToValue.get("aeronetIstrumentNumber");
    }

    public void setAeronetIstrumentNumber(Integer aeronetIstrumentNumber) {
        fieldToValue.put("aeronetIstrumentNumber", aeronetIstrumentNumber);
    }

    public String getAeronetSiteName() {
        return (String)fieldToValue.get("aeronetSiteName");
    }

    public void setAeronetSiteName(String aeronetSiteName) {
        fieldToValue.put("aeronetSiteName", aeronetSiteName);
    }

    public Double getSiteLatitudeDegrees() {
        return (Double)fieldToValue.get("siteLatitudeDegrees");
    }

    public void setSiteLatitudeDegrees(Double siteLatitudeDegrees) {
        fieldToValue.put("siteLatitudeDegrees", siteLatitudeDegrees);
    }

    public Double getSiteLongitudeDegrees() {
        return (Double)fieldToValue.get("siteLongitudeDegrees");
    }

    public void setSiteLongitudeDegrees(Double siteLongitudeDegrees) {
        fieldToValue.put("siteLongitudeDegrees", siteLongitudeDegrees);
    }

    public Double getSiteelevation() {
        return (Double)fieldToValue.get("siteelevation");
    }

    public void setSiteelevation(Double siteelevation) {
        fieldToValue.put("siteelevation", siteelevation);
    }

    public Double getSolarZenitAngleDegrees() {
        return (Double)fieldToValue.get("solarZenitAngleDegrees");
    }

    public void setSolarZenitAngleDegrees(Double solarZenitAngleDegrees) {
        fieldToValue.put("solarZenitAngleDegrees", solarZenitAngleDegrees);
    }

    public Double getOpticalAirMass() {
        return (Double)fieldToValue.get("opticalAirMass");
    }

    public void setOpticalAirMass(Double opticalAirMass) {
        fieldToValue.put("opticalAirMass", opticalAirMass);
    }

    public Double getSensorTemperatureDegreesC() {
        return (Double)fieldToValue.get("sensorTemperatureDegreesC");
    }

    public void setSensorTemperatureDegreesC(Double sensorTemperatureDegreesC) {
        fieldToValue.put("sensorTemperatureDegreesC", sensorTemperatureDegreesC);
    }

    public Double getOzoneDobson() {
        return (Double)fieldToValue.get("ozoneDobson");
    }

    public void setOzoneDobson(Double ozoneDobson) {
        fieldToValue.put("ozoneDobson", ozoneDobson);
    }

    public Double getNO2Dobson() {
        return (Double)fieldToValue.get("NO2Dobson");
    }

    public void setNO2Dobson(Double NO2Dobson) {
        fieldToValue.put("NO2Dobson", NO2Dobson);
    }

    public LocalDate getLastDateProcessed() {
        return (LocalDate)fieldToValue.get("lastDateProcessed");
    }

    public void setLastDateProcessed(Date lastDateProcessed) {
        fieldToValue.put("lastDateProcessed", lastDateProcessed);
    }

    public Integer getNumberOfWavelengths() {
        return (Integer)fieldToValue.get("numberOfWavelengths");
    }

    public void setNumberOfWavelengths(Integer numberOfWavelengths) {
        fieldToValue.put("numberOfWavelengths", numberOfWavelengths);
    }

    public Double getExactWavelengthsOfAOD1640() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD1640");
    }

    public void setExactWavelengthsOfAOD1640(Double exactWavelengthsOfAOD1640) {
        fieldToValue.put("exactWavelengthsOfAOD1640", exactWavelengthsOfAOD1640);
    }

    public Double getExactWavelengthsOfAOD1020() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD1020");
    }

    public void setExactWavelengthsOfAOD1020(Double exactWavelengthsOfAOD1020) {
        fieldToValue.put("exactWavelengthsOfAOD1020", exactWavelengthsOfAOD1020);
    }

    public Double getExactWavelengthsOfAOD870() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD870");
    }

    public void setExactWavelengthsOfAOD870(Double exactWavelengthsOfAOD870) {
        fieldToValue.put("exactWavelengthsOfAOD870", exactWavelengthsOfAOD870);
    }

    public Double getExactWavelengthsOfAOD865() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD865");
    }

    public void setExactWavelengthsOfAOD865(Double exactWavelengthsOfAOD865) {
        fieldToValue.put("exactWavelengthsOfAOD865", exactWavelengthsOfAOD865);
    }

    public Double getExactWavelengthsOfAOD779() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD779");
    }

    public void setExactWavelengthsOfAOD779(Double exactWavelengthsOfAOD779) {
        fieldToValue.put("exactWavelengthsOfAOD779", exactWavelengthsOfAOD779);
    }

    public Double getExactWavelengthsOfAOD675() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD675");
    }

    public void setExactWavelengthsOfAOD675(Double exactWavelengthsOfAOD675) {
        fieldToValue.put("exactWavelengthsOfAOD675", exactWavelengthsOfAOD675);
    }

    public Double getExactWavelengthsOfAOD667() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD667");
    }

    public void setExactWavelengthsOfAOD667(Double exactWavelengthsOfAOD667) {
        fieldToValue.put("exactWavelengthsOfAOD667", exactWavelengthsOfAOD667);
    }

    public Double getExactWavelengthsOfAOD620() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD620");
    }

    public void setExactWavelengthsOfAOD620(Double exactWavelengthsOfAOD620) {
        fieldToValue.put("exactWavelengthsOfAOD620", exactWavelengthsOfAOD620);
    }

    public Double getExactWavelengthsOfAOD560() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD560");
    }

    public void setExactWavelengthsOfAOD560(Double exactWavelengthsOfAOD560) {
        fieldToValue.put("exactWavelengthsOfAOD560", exactWavelengthsOfAOD560);
    }

    public Double getExactWavelengthsOfAOD555() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD555");
    }

    public void setExactWavelengthsOfAOD555(Double exactWavelengthsOfAOD555) {
        fieldToValue.put("exactWavelengthsOfAOD555", exactWavelengthsOfAOD555);
    }

    public Double getExactWavelengthsOfAOD551() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD551");
    }

    public void setExactWavelengthsOfAOD551(Double exactWavelengthsOfAOD551) {
        fieldToValue.put("exactWavelengthsOfAOD551", exactWavelengthsOfAOD551);
    }

    public Double getExactWavelengthsOfAOD532() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD532");
    }

    public void setExactWavelengthsOfAOD532(Double exactWavelengthsOfAOD532) {
        fieldToValue.put("exactWavelengthsOfAOD532", exactWavelengthsOfAOD532);
    }

    public Double getExactWavelengthsOfAOD531() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD531");
    }

    public void setExactWavelengthsOfAOD531(Double exactWavelengthsOfAOD531) {
        fieldToValue.put("exactWavelengthsOfAOD531", exactWavelengthsOfAOD531);
    }

    public Double getExactWavelengthsOfAOD510() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD510");
    }

    public void setExactWavelengthsOfAOD510(Double exactWavelengthsOfAOD510) {
        fieldToValue.put("exactWavelengthsOfAOD510", exactWavelengthsOfAOD510);
    }

    public Double getExactWavelengthsOfAOD500() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD500");
    }

    public void setExactWavelengthsOfAOD500(Double exactWavelengthsOfAOD500) {
        fieldToValue.put("exactWavelengthsOfAOD500", exactWavelengthsOfAOD500);
    }

    public Double getExactWavelengthsOfAOD490() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD490");
    }

    public void setExactWavelengthsOfAOD490(Double exactWavelengthsOfAOD490) {
        fieldToValue.put("exactWavelengthsOfAOD490", exactWavelengthsOfAOD490);
    }

    public Double getExactWavelengthsOfAOD443() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD443");
    }

    public void setExactWavelengthsOfAOD443(Double exactWavelengthsOfAOD443) {
        fieldToValue.put("exactWavelengthsOfAOD443", exactWavelengthsOfAOD443);
    }

    public Double getExactWavelengthsOfAOD440() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD440");
    }

    public void setExactWavelengthsOfAOD440(Double exactWavelengthsOfAOD440) {
        fieldToValue.put("exactWavelengthsOfAOD440", exactWavelengthsOfAOD440);
    }

    public Double getExactWavelengthsOfAOD412() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD412");
    }

    public void setExactWavelengthsOfAOD412(Double exactWavelengthsOfAOD412) {
        fieldToValue.put("exactWavelengthsOfAOD412", exactWavelengthsOfAOD412);
    }

    public Double getExactWavelengthsOfAOD400() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD400");
    }

    public void setExactWavelengthsOfAOD400(Double exactWavelengthsOfAOD400) {
        fieldToValue.put("exactWavelengthsOfAOD400", exactWavelengthsOfAOD400);
    }

    public Double getExactWavelengthsOfAOD380() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD380");
    }

    public void setExactWavelengthsOfAOD380(Double exactWavelengthsOfAOD380) {
        fieldToValue.put("exactWavelengthsOfAOD380", exactWavelengthsOfAOD380);
    }

    public Double getExactWavelengthsOfAOD340() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD340");
    }

    public void setExactWavelengthsOfAOD340(Double exactWavelengthsOfAOD340) {
        fieldToValue.put("exactWavelengthsOfAOD340", exactWavelengthsOfAOD340);
    }

    public Double getExactWavelengthsOfPW935() {
        return (Double)fieldToValue.get("exactWavelengthsOfPW935");
    }

    public void setExactWavelengthsOfPW935(Double exactWavelengthsOfPW935) {
        fieldToValue.put("exactWavelengthsOfPW935", exactWavelengthsOfPW935);
    }

    public Double getExactWavelengthsOfAOD681() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD681");
    }

    public void setExactWavelengthsOfAOD681(Double exactWavelengthsOfAOD681) {
        fieldToValue.put("exactWavelengthsOfAOD681", exactWavelengthsOfAOD681);
    }

    public Double getExactWavelengthsOfAOD709() {
        return (Double)fieldToValue.get("exactWavelengthsOfAOD709");
    }

    public void setExactWavelengthsOfAOD709(Double exactWavelengthsOfAOD709) {
        fieldToValue.put("exactWavelengthsOfAOD709", exactWavelengthsOfAOD709);
    }

    public Double getExactWavelengthsOfAODEmpty1() {
        return (Double)fieldToValue.get("exactWavelengthsOfAODEmpty1");
    }

    public void setExactWavelengthsOfAODEmpty1(Double exactWavelengthsOfAODEmpty1) {
        fieldToValue.put("exactWavelengthsOfAODEmpty1", exactWavelengthsOfAODEmpty1);
    }

    public Double getExactWavelengthsOfAODEmpty2() {
        return (Double)fieldToValue.get("exactWavelengthsOfAODEmpty2");
    }

    public void setExactWavelengthsOfAODEmpty2(Double exactWavelengthsOfAODEmpty2) {
        fieldToValue.put("exactWavelengthsOfAODEmpty2", exactWavelengthsOfAODEmpty2);
    }

    public Double getExactWavelengthsOfAODEmpty3() {
        return (Double)fieldToValue.get("exactWavelengthsOfAODEmpty3");
    }

    public void setExactWavelengthsOfAODEmpty3(Double exactWavelengthsOfAODEmpty3) {
        fieldToValue.put("exactWavelengthsOfAODEmpty3", exactWavelengthsOfAODEmpty3);
    }

    public Double getExactWavelengthsOfAODEmpty4() {
        return (Double)fieldToValue.get("exactWavelengthsOfAODEmpty4");
    }

    public void setExactWavelengthsOfAODEmpty4(Double exactWavelengthsOfAODEmpty4) {
        fieldToValue.put("exactWavelengthsOfAODEmpty4", exactWavelengthsOfAODEmpty4);
    }

    public Double getExactWavelengthsOfAODEmpty5() {
        return (Double)fieldToValue.get("exactWavelengthsOfAODEmpty5");
    }

    public void setExactWavelengthsOfAODEmpty5(Double exactWavelengthsOfAODEmpty5) {
        fieldToValue.put("exactWavelengthsOfAODEmpty5", exactWavelengthsOfAODEmpty5);
    }

    public Double getExactWavelengthsOfAODEmpty6() {
        return (Double)fieldToValue.get("exactWavelengthsOfAODEmpty6");
    }

    public void setExactWavelengthsOfAODEmpty6(Double exactWavelengthsOfAODEmpty6) {
        fieldToValue.put("exactWavelengthsOfAODEmpty6", exactWavelengthsOfAODEmpty6);
    }

    @Override
    public String toString() {
        String result = "";

        for (String currentStringName : fieldToValue.keySet()) {
            result += currentStringName + " = " + getValueFromField(currentStringName) + ",\n";
        }

        return result;
    }
}
