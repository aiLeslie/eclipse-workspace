package com.leslie.handlerPro.handlers;

public class TempHandler extends AbstractHandler<String> {
	 private String deviceId;
	    private String taskId;
	    private String temp;
	    private TempAlarm alarm = new TempAlarm();


	    public void setDeviceId(String deviceId) {
	        this.deviceId = deviceId;
	    }

	    public void setTaskId(String taskId) {
	        this.taskId = taskId;
	    }

	    public void setTemp(String temp) {
	        this.temp = temp;
	        alarm.checkTemp(temp);
	    }

	    public String getDeviceId() {
	        return deviceId;
	    }

	    public String getTaskId() {
	        return taskId;
	    }

	    public String getTemp() {
	        return temp;
	    }

	    public TempAlarm getAlarm() {
	        return alarm;
	    }

	    @Override
	    protected TempParser injectParser() {
	        return new TempParser();
	    }

	    public static class TempAlarm {
	        private int tempLimit = 30;
	        private int countLimit = 10;
	        private int count = 0;
	        boolean isAlarm = false;
//	        private Handler handler = new Handler(Looper.getMainLooper());
	        private Alarm alarm;

	        public void setAlarm(Alarm alarm) {
	            this.alarm = alarm;
	        }

	        public boolean isAlarm() {
	            return isAlarm;
	        }

	        public synchronized void reset() {
	            count = 0;
	            isAlarm = false;
	        }

	        private void checkTemp(String temp) {
	            double t = Double.parseDouble(temp);

	            if (t < tempLimit) {
	                count = 0;

	            }  else {
	                count++;
	            }

	            if (count >= countLimit) {
	                isAlarm = true;
	                processAlarm();
	            }
	        }

	        private synchronized void processAlarm() {
	            if (isAlarm && count == countLimit) {
	            	alarm.onAlarm();
	            }

	        }

	        public interface Alarm {
	            void onAlarm();
	        }
	    }
}
