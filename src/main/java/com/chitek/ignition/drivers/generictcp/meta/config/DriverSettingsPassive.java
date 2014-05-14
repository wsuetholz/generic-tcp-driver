package com.chitek.ignition.drivers.generictcp.meta.config;

import java.nio.ByteOrder;
import java.util.List;

import com.chitek.ignition.drivers.generictcp.types.OptionalDataType;
import com.chitek.ignition.drivers.generictcp.types.PassiveModeDevice;

/**
 * This class wraps general driver settings. In addition, the messageIdType is also availabe from this class though it is not a
 * setting, but configured with the message.
 *
 */
public class DriverSettingsPassive implements IDriverSettings {
	private final String serverHostname;
	private final int serverPort;
	private final List<PassiveModeDevice> devices;
	private final int messageTimeout = 1000;
	private final ByteOrder byteOrder;
	private final int timestampFactor;
	private final OptionalDataType messageIdType;

	public DriverSettingsPassive(
		String serverHostname,
		int serverPort,
		List<PassiveModeDevice> devices,
		boolean reverseByteOrder,
		int timestampFactor,
		OptionalDataType messageIdType)
	{
		this.serverHostname = serverHostname;
		this.serverPort = serverPort;
		this.devices = devices;
		this.byteOrder = reverseByteOrder ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
		this.timestampFactor = timestampFactor;
		this.messageIdType = messageIdType;
	}

	public String getServerAddress() {
		return serverHostname;
	}

	public int getServerPort() {
		return serverPort;
	}

	public List<PassiveModeDevice> getDevices() {
		return devices;
	}

	/**
	 * The maximum time between two parts of a data package. If a package is not completed in
	 * the time given here, incoming data will be discarded.
	 * 
	 * @return
	 */
	@Override
	public int getMessageTimeout() {
		return messageTimeout;
	}

	@Override
	public ByteOrder getByteOrder() {
		return byteOrder;
	}

	@Override
	public int getTimestampFactor() {
		return timestampFactor;
	}

	/**
	 * @return
	 * 		The message id type from the message config. This is no general setting, but
	 * 		added here for convenience.
	 */
	@Override
	public OptionalDataType getMessageIdType() {
		return messageIdType;
	}

}