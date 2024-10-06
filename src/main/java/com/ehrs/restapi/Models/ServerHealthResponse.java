package com.ehrs.restapi.Models;

public class ServerHealthResponse {
	private String serverStatus;
    private String databaseStatus;

    public String getServerStatus() {
        return serverStatus;
    }
    public String getDatabaseStatus() {
        return databaseStatus;
    }
}
