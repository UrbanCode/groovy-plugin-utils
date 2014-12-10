package com.urbancode.air

class Folder {
    def id
    def name
    def parentId
    def Map<String, Folder> children = new HashMap<String, Folder>()
    
    public Folder(id, name, parentId) {
        this.id = id
        this.name = name
        this.parentId = parentId
    }

    public boolean equals(Object o) {
        if (o instanceof Folder && o != null) {
            return id.equals(o.id)
        }
        else {
            return false
        }
    }

    public String toString() {
        return "[id:$id, name:$name, parent:$parentId, children:${children.keySet()}]"
    }
}

