package com.huamiao.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 〈生成唯一id〉
 */
@Component
@Slf4j
public class IdGenerator {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long workerId;//为终端ID
    private long datacenterId;//数据中心ID
    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        workerId = getWorkId();
        datacenterId = getDataCenterId();

        log.info("当前机器的workId:{},datacenterId:{}", workerId, datacenterId);
        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
    }

    public synchronized String nextIdStr() {
        return snowflake.nextIdStr();
    }

    public synchronized String nextIdStr(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextIdStr();
    }


    /**
     * workId使用IP生成
     * @return workId
     */
    private static Long getWorkId() {
        try {
            String hostAddress = getLocalIP();
            log.info("当前机器地址{}", hostAddress);
            int[] ints = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for (int b : ints) {
                sums = sums + b;
            }
            return (long) (sums % 32);
        }
        catch (Exception e) {
            // 失败就随机
            return RandomUtils.nextLong(0, 31);
        }
    }

    /**
     * dataCenterId使用hostName生成
     * @return dataCenterId
     */
    private static Long getDataCenterId() {
        try {
            String hostName = SystemUtils.getHostName();
            log.info("当前机器名称{}", hostName);
            int[] ints = StringUtils.toCodePoints(hostName);
            int sums = 0;
            for (int i: ints) {
                sums = sums + i;
            }
            return (long) (sums % 32);
        }
        catch (Exception e) {
            // 失败就随机
            return RandomUtils.nextLong(0, 31);
        }
    }


    /**
     * 获得本地ip
     * @return
     */
    private static String getLocalIP() {
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = netInterfaces.nextElement();
                if (!nextElement.isUp() || nextElement.isLoopback()) {
                    continue;
                }
                // 遍历所有ip
                Enumeration<InetAddress> ips = nextElement.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress inetAddress = ips.nextElement();
                    if (null == inetAddress || "".equals(inetAddress)) {
                        continue;
                    }
                    String sIP = inetAddress.getHostAddress();
                    if (sIP == null || sIP.indexOf(":") > -1) {
                        continue;
                    }
                    if ("127.0.0.1".equals(sIP)) {
                        continue;
                    }else{
                        return sIP;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}