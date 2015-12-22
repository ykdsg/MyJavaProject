package com.hz.yk.yk.quartz;

import java.util.HashMap;

public class JobDetail {
    private Class<? extends Job> clazz;
    private String jobName;
    private HashMap<String, String> jobData;

    public JobDetail() {
        jobData = new HashMap<String, String>();
    }

    public JobDetail(String name, Class<? extends Job> clazz) {
        this();
        this.jobName = name;
        this.clazz = clazz;
    }

    /**
     * @return the clazz
     */
    public Class<? extends Job> getClazz() {
        return clazz;
    }

    /**
     * @param clazz the clazz to set
     */
    public void setClazz(Class<? extends Job> clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the jobDetail
     */
    public HashMap<String, String> getJobData() {
        return jobData;
    }

    /**
     * @param jobDetail the jobDetail to set
     */
    public void setJobData(HashMap<String, String> jobDetail) {
        this.jobData = jobDetail;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        JobDetail other = (JobDetail) obj;
        if (jobName == null) {
            if (other.jobName != null)
                return false;
        } else if (!jobName.equals(other.jobName))
            return false;
        return true;
    }
}
