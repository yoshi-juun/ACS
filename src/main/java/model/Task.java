package model;

import java.util.Date;

public class Task {
    private int taskId;                 // タスクID
    private int customerId;             // 顧客ID
    private String customerName;        // 顧客の名前
    private Date orderDate;             // 受注日時
    private Date completionDate;        // Complete日時
    private String taskName;            // タスク名
    private String details;             // 詳細
    private String priority;            // 優先度 (高, 中, 低)
    private Date deadline;              // 期限
    private String status;              // 進捗状況 (No, InProgress, Complete)
    private int conciergeId;            // 対応コンシェルジュID
    private int requiredTime;           // 所要時間 (分)

    // コンストラクタ
    public Task(int taskId, int customerId, String customerName, Date orderDate, String taskName, String details,
                String priority, Date deadline, String status, int conciergeId, int requiredTime, Date completionDate) {
        this.taskId = taskId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.completionDate = completionDate; // 初期はnull、Complete時に設定
        this.taskName = taskName;
        this.details = details;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
        this.conciergeId = conciergeId;
        this.requiredTime = requiredTime;
    }

    // ゲッターとセッター
    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getConciergeId() {
        return conciergeId;
    }

    public void setConciergeId(int conciergeId) {
        this.conciergeId = conciergeId;
    }

    public void setRequiredTime(int requiredTime) {
        this.requiredTime = requiredTime;
    }

    public int getCustomerId(){return customerId;}
    public String getDetails(){return details;}
    public String getCustomerName() { return customerName; }
    public String getTaskName() { return taskName; }
    public String getPriority() { return priority; }
    public Date getDeadline() { return deadline; }
    public Date getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getRequiredTime(){return requiredTime;}
    
    // Complete日時を取得
    public Date getCompletionDate() { return completionDate; } // 追加したゲッターメソッド

    // Complete日時を設定
    public void completeTask(Date completionDate) {
        this.completionDate = completionDate;
        this.status = "Complete";
    }
}
