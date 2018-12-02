package controlutil;
/**
 *
 * 项目名称：Controler
 * 类名称：Task
 * 类描述：
 * 创建人：李玮斌
 * 创建时间：2018年4月24日 上午2:04:19
 * @version 1.0
 */
public class Task {
	public static final byte Start_Default = (byte)0x02;
	public static final byte End_Default = (byte)0x03;

	private byte start = Start_Default;//数据包开头
	private byte length;//数据包长度
	private byte id;//任务id
	public Orientation orientation;//方向
	public boolean isOrientation = false;
	private byte[] importanceData;//重要的传输数据
	private byte checkAnd;//校验和
	private byte end = End_Default;//数据包结尾
	private byte[] bytes;//表示任务的所有属性的字节数组
	/**
	 * 通用任务构造方法
	 * @param id
	 * @param importanceData
	 */
	public Task(byte id, byte[] importanceData) {
		super();
		if (importanceData == null)throw new IllegalArgumentException();
		this.id = id;
		this.importanceData = importanceData;
		this.length = (byte) (importanceData.length + 5);
		upDateCheckAnd();
	}
	/**
	 * 通用任务构造方法
	 * @param id
	 * @param importanceData
	 */
	public Task(byte start,byte id, byte[] importanceData, byte end) {
		super();
		if (importanceData == null)throw new IllegalArgumentException();
		this.start = start;
		this.end = end;
		this.id = id;
		this.importanceData = importanceData;
		this.length = (byte) (importanceData.length + 5);
		upDateCheckAnd();
	}


	/**
	 * 使用方向作为重要传输数据的任务构造方法
	 * @param start
	 * @param id
	 * @param isReverse
	 * @param isRight
	 * @param speed
	 * @param end
	 */
	public Task(byte start, byte id,byte isReverse, byte isRight, byte speed, byte end) {
		super();
		isOrientation = true;
		this.start = start;
		this.id = id;
		orientation = this.new Orientation(isReverse, isRight, speed);
		importanceData = new byte[]{isReverse, isRight, speed};
		this.end = end;
		upDateCheckAnd();
	}

	/**
	 * 把接收的数据构建Rtask实例
	 * @param start
	 * @param length
	 * @param id
	 * @param importanceData
	 * @param checkAnd
	 * @param end
	 * @return
	 */
	public static Task CreateRtask(byte start, byte length, byte id, byte[] importanceData, byte checkAnd, byte end){
		return new Task (start,length,id,importanceData,checkAnd,end);
	}
	public Task(byte[] bytes){
		this.bytes = bytes;
		this.start = bytes[0];
		this.length = bytes[1];
		this.id = bytes[2];
		this.importanceData = new byte[bytes.length - 2 - 2 - 1];
		for (int i = 0 ; i < importanceData.length ; i++){
			importanceData[i] = bytes[3 + i];
		}
		this.checkAnd = bytes[bytes.length - 2];
		this.end = bytes[bytes.length - 1];
	}


	private Task(byte start, byte length, byte id, byte[] importanceData, byte checkAnd, byte end) {
		this.start = start;
		this.length = length;
		this.id = id;
		this.importanceData = importanceData;
		this.checkAnd = checkAnd;
		this.end = end;
	}
	/**
	 *
	 * @return 表示任务的所有属性的字节数组
	 */
	public byte[] getBytes() {
		this.bytes = new byte[this.length];
		bytes[0] = this.start;
		bytes[1] = this.length;
		bytes[2] = this.id;
		for (int i = 0 ; i < importanceData.length;i++) {
			bytes[3 + i] = importanceData[i];
		}
		bytes[length - 2] = this.checkAnd;
		bytes[length - 1] = this.end;
		return bytes;
	}


	public byte[] getImportanceData() {
		return importanceData;
	}
	public void setImportanceData(byte[] importanceData) {
		this.importanceData = importanceData;
		upDateCheckAnd();
	}
	public  void upDateCheckAnd() {
		this.length = (byte) (importanceData.length + 5);
		this.checkAnd = (byte)(this.id + this.length + this.getImportanceDataSum());
	}
	public static boolean communicationIsSuccess(Task task) {
		if (task.checkAnd == task.id + task.length + task.getImportanceDataSum() && task.start == Start_Default && task.end == End_Default) {
			return true;
		}else if (task.id == 2 && task.checkAnd == task.id + task.length && task.start == Start_Default && task.end == End_Default) {
			return true;
		}else {
			return false;
		}
	}
	public byte getStart() {
		return start;
	}
	public byte getId() {
		return id;
	}
	public byte getLength() {
		return length;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (byte b :getBytes()){
			builder.append(b);
			builder.append(" ");
		}
		return builder.toString();
	}
	private byte getImportanceDataSum() {
		byte sum = 0;
		for (byte b : importanceData) {
			sum += b;
		}
		return sum;
	}

	public class Orientation{

		public Orientation(byte isReverse, byte isStraight, byte speed) {
			super();
			this.isReverse = isReverse;
			this.isStraight = isStraight;
			this.speed = speed;
		}
		private byte isReverse;
		private byte isStraight;
		private byte speed;
		public byte getIsReverse() {
			return isReverse;
		}
		public void setIsReverse(byte isReverse) {
			this.isReverse = isReverse;
		}
		public byte getIsStraight() {
			return isStraight;
		}
		public void setIsRight(byte isStraight) {
			this.isStraight = isStraight;
		}
		public byte getSpeed() {
			return speed;
		}
		public void setSpeed(byte speed) {
			this.speed = speed;
		}

	}

}
