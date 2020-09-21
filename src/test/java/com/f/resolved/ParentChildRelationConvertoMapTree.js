function convertDictionaryToMapTree(list) {
    let currentMap = new Map();
    for (let item of list) {
        let childMap = new Map();
        childMap.set(item["dicCode"], item["dicName"]);
        let child = item["children"];
        if (null != child && child.length > 0) {
            childMap.set("child", convertDictionaryToMapTree(child));
        }
        currentMap.set(item["dicCode"], childMap);
    }
    return currentMap;
}
