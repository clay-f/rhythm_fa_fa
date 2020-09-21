/**
 * 把具有父子关系的对象，转化为 map tree
 * 
 */




var data = [
  {
    "creationTime": "2020-09-16",
    "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
    "deleted": null,
    "deletionTime": null,
    "deleterUserId": null,
    "automaticId": 161,
    "id": "921c86ffa16e44a3919187b210d7996f",
    "dicKey": "月度奖项积分",
    "dicCode": "MONTHLY_BONUSES",
    "dicName": "月度奖项积分",
    "description": "",
    "parentId": null,
    "sort": 1350,
    "fullSort": 1350,
    "level": 1,
    "fullDicCode": "MONTHLY_BONUSES",
    "children": [
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "d09a2a32e6fd48f0bad4606f749e6572",
        "dicKey": "月度奖项积分_新人破冰奖",
        "dicCode": "MONTHLY_BONUSES_FRESHMAN_BREAK_THE_ICE-0.5",
        "dicName": "新人破冰奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1351,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_FRESHMAN_BREAK_THE_ICE-0.5",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "b6f463ac70e3474cb7bdd6c0a362c4cd",
        "dicKey": "月度奖项积分_最佳签单奖",
        "dicCode": "MONTHLY_BONUSES_BEST_SIGN_THE_BILL-1.5",
        "dicName": "最佳签单奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1352,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_BEST_SIGN_THE_BILL-1.5",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "5bac30baa5f04cf6a84a97678a5dfb7a",
        "dicKey": "月度奖项积分_最佳回款奖",
        "dicCode": "MONTHLY_BONUSES_BEST_RECEIVED_PAYMENTS-1.5",
        "dicName": "最佳回款奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1353,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_BEST_RECEIVED_PAYMENTS-1.5",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "7be74b8a040a4490800e8bce55d385f7",
        "dicKey": "月度奖项积分_优秀表现奖",
        "dicCode": "MONTHLY_BONUSES_EXCELLENT_ACTION-1",
        "dicName": "优秀表现奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1354,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_EXCELLENT_ACTION-1",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "6de231aa01fa4ce5b84b74c4f9d7d65e",
        "dicKey": "月度奖项积分_成长之星奖",
        "dicCode": "MONTHLY_BONUSES_GROWTH_STAR-1",
        "dicName": "成长之星奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1355,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_GROWTH_STAR-1",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "c1d675efc4b14d34b67cb851b0cd9fc7",
        "dicKey": "月度奖项积分_特别奖",
        "dicCode": "MONTHLY_BONUSES_SPECIAL-1",
        "dicName": "特别奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1356,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_SPECIAL-1",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "de7493c03b4d4266825512511f037ee3",
        "dicKey": "月度奖项积分_月度最佳表演奖",
        "dicCode": "MONTHLY_BONUSES_BEST_SHOW-0.5",
        "dicName": "月度最佳表演奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1357,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_BEST_SHOW-0.5",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "b37ca9bfb0a146c386f59276cba556dc",
        "dicKey": "月度奖项积分_卓越团队奖",
        "dicCode": "MONTHLY_BONUSES_BEST_TEAM_EXCELLENT-1",
        "dicName": "卓越团队奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1358,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_BEST_TEAM_EXCELLENT-1",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "f37b0a04f4a74c9abdcd2061367a9ec7",
        "dicKey": "月度奖项积分_优秀团队奖",
        "dicCode": "MONTHLY_BONUSES_GREET_TEAM-0.5",
        "dicName": "优秀团队奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1359,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_GREET_TEAM-0.5",
        "children": []
      },
      {
        "creationTime": "2020-09-16",
        "creatorUserId": "8e9aeb52449644aca7c2127852cb8501",
        "deleted": null,
        "deletionTime": null,
        "deleterUserId": null,
        "automaticId": 161,
        "id": "29398e0ff7ac4a23a3bab3916ffc0dba",
        "dicKey": "月度奖项积分_优秀主管奖",
        "dicCode": "MONTHLY_BONUSES_EXCELLENT_DIRECTOR-1",
        "dicName": "优秀主管奖",
        "description": "",
        "parentId": "921c86ffa16e44a3919187b210d7996f",
        "sort": 1360,
        "fullSort": 1350,
        "level": 2,
        "fullDicCode": "MONTHLY_BONUSES/MONTHLY_BONUSES_EXCELLENT_DIRECTOR-1",
        "children": []
      }
    ]
  }
];


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
