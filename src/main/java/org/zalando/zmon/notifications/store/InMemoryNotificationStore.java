package org.zalando.zmon.notifications.store;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class InMemoryNotificationStore implements NotificationStore {
    private final Multimap<String, String> devices = ArrayListMultimap.create();
    private final Multimap<Integer, String> alerts = ArrayListMultimap.create();
    private final Multimap<String, Integer> alertsForUid = ArrayListMultimap.create();

    @Override
    public void addDeviceForUid(String deviceId, String uid) {
        devices.put(uid, deviceId);
    }

    @Override
    public void addAlertForUid(int alertId, String uid) {
        alerts.put(alertId, uid);
    }

    @Override
    public void removeDeviceForUid(String deviceId, String uid) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAlertForUid(int alertId, String uid) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Integer> alertsForUid(String uid) {
        return alertsForUid.get(uid);
    }

    @Override
    public Collection<String> devicesForUid(String uid) {
        return null;
    }

    @Override
    public void addTeamToUid(String team, String uid) {

    }

    @Override
    public void removeTeamFromUid(String team, String uid) {

    }

    @Override
    public Collection<String> teamsForUid(String uid) {
        return null;
    }

    @Override
    public Collection<String> devicesForAlerts(int alertId, String team, int priority) {
        ArrayList<String> result = new ArrayList<>();
        for (String uid : alerts.get(alertId)) {
            result.addAll(devices.get(uid));
        }
        return result;
    }

    @Override
    public Collection<String> getAllDeviceIds() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("in-mem-store: devices=%s alerts=%s", devices, alerts);
    }

    @Override
    public int getPriority(String uid) {
        return 0;
    }

    @Override
    public void setPriority(int priority, String uid) {

    }
}
