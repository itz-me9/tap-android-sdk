package com.tapwithus.sdk.bluetooth.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.support.annotation.NonNull;

import com.tapwithus.sdk.bluetooth.ErrorStrings;

import java.util.UUID;

public class CharacteristicReadOperation extends CharacteristicOperation {

    public CharacteristicReadOperation(UUID service, UUID characteristic) {
        super(service, characteristic);
    }

    @Override
    public OperationType type() {
        return OperationType.CHAR_READ;
    }

    @Override
    public void onExecute(@NonNull BluetoothGatt gatt) {
        BluetoothGattCharacteristic c = extractCharacteristic(gatt);
        if (c == null) {
            postOnError(ErrorStrings.NO_CHARACTERISTIC);
            return;
        }

        if (!gatt.readCharacteristic(c)) {
            postOnError(ErrorStrings.WRITE_OP_INIT_FAIL);
        }
    }
}
