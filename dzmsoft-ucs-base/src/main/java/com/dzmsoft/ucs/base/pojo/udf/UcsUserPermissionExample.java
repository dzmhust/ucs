package com.dzmsoft.ucs.base.pojo.udf;

import com.dzmsoft.ucs.base.pojo.UcsPermissionExample;
import com.dzmsoft.ucs.base.pojo.UcsUserExample;

public class UcsUserPermissionExample {
	private UcsUserExample ucsUserExample;
	private UcsPermissionExample ucsPermissionExample;
	private com.dzmsoft.ucs.base.pojo.UcsRolePermissionExample ucsRolePermissionExample;
	
	public UcsUserPermissionExample(){
		this.ucsUserExample = new UcsUserExample();
		this.ucsPermissionExample = new UcsPermissionExample();
		this.ucsRolePermissionExample = new com.dzmsoft.ucs.base.pojo.UcsRolePermissionExample();
	}
	
	public UcsUserExample getUcsUserExample() {
		return ucsUserExample;
	}
	public void setUcsUserExample(UcsUserExample ucsUserExample) {
		this.ucsUserExample = ucsUserExample;
	}
	public UcsPermissionExample getUcsPermissionExample() {
		return ucsPermissionExample;
	}
	public void setUcsPermissionExample(UcsPermissionExample ucsPermissionExample) {
		this.ucsPermissionExample = ucsPermissionExample;
	}

    public com.dzmsoft.ucs.base.pojo.UcsRolePermissionExample getUcsRolePermissionExample() {
        return ucsRolePermissionExample;
    }

    public void setUcsRolePermissionExample(com.dzmsoft.ucs.base.pojo.UcsRolePermissionExample ucsRolePermissionExample) {
        this.ucsRolePermissionExample = ucsRolePermissionExample;
    }
	
	
}
