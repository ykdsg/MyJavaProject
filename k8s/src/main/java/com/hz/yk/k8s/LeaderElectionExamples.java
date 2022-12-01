package com.hz.yk.k8s;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderCallbacks;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectionConfigBuilder;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaseLock;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author wuzheng.yk
 * @date 2022/12/1
 */
public class LeaderElectionExamples {

    private static final String NAMESPACE = "default";
    private static final String NAME = "leaders-of-the-future";

    public static final class SingleThreadExample {

        public static void main(String[] args) {
            final String lockIdentity = UUID.randomUUID().toString();
            KubernetesClient kc = getKubernetesClient();
            if (kc == null) {
                return;
            }
            kc.leaderElector().withConfig(
                    new LeaderElectionConfigBuilder().withName("Sample Leader Election configuration")
                            .withLeaseDuration(Duration.ofSeconds(15L))
                            .withLock(new LeaseLock(NAMESPACE, NAME, lockIdentity))
                            .withRenewDeadline(Duration.ofSeconds(10L)).withRetryPeriod(Duration.ofSeconds(2L))
                            .withLeaderCallbacks(new LeaderCallbacks(() -> System.out.println("STARTED LEADERSHIP"),
                                                                     () -> System.out.println("STOPPED LEADERSHIP"),
                                                                     newLeader -> System.out.printf(
                                                                             "New leader elected %s%n", newLeader)))
                            .build()).build().run();
        }

    }


    @Nullable
    private static KubernetesClient getKubernetesClient() {
        String configFilePath = "kubeconfig" + File.separator + "hione-test";
        KubernetesClient kc;
        try (InputStream inputStream = LeaderElectionExamples.class.getClassLoader()
                .getResourceAsStream(configFilePath)) {
            if (inputStream == null) {
                System.err.println("load kube config file failed. file not exists.");
            }
            String contents = IOUtils.toString(inputStream, UTF_8);
            if (StringUtils.isBlank(contents)) {
                return null;
            }
            Config config = Config.fromKubeconfig(contents);
            kc = new DefaultKubernetesClient(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return kc;
    }
}
