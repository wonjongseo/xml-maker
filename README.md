#  世宗大学校のXML授業であるプロジェクトです。

## プログラムを始めます。
![](https://velog.velcdn.com/images/wonjongseo/post/e3a28e39-b11e-456f-9adc-8133ee92102c/image.png)

プログラムを開始しますと、最初に作業のディレクトリPathを入力してください。


![](https://velog.velcdn.com/images/wonjongseo/post/1e869693-1126-411c-b336-24a70a850e32/image.png)
（入力しない場合は、オペレーティングシステムrootPathに指定します。）




## Main Page
[](https://velog.velcdn.com/images/wonjongseo/post/4d97d0b7-fb96-411b-81fa-693aaa6a0c40/image.png)

メインページには、各種機能を持つ九つのボタンが存在します。
ボタンの反応に対するメッセージが存在します。

## Load Page

![](https://velog.velcdn.com/images/wonjongseo/post/9d0de69d-13a5-446f-941d-c8673851aae7/image.png)

Loadボタンを押しますと、初期指定したディレクトリPathのファイルリストが表示されます。

![](https://velog.velcdn.com/images/wonjongseo/post/26cd43e2-8267-4444-931b-2fce51df63d7/image.png)

ファイルをクリックし、「開く」を押すとファイルがロードされます。
Xmlではなくファイルをロードする時、「ロぐ失敗」のメッセージを出力します。

XMLをロードする前に、Find、Save、Print、Insert、Update、Deleteボタンを押すと

![](https://velog.velcdn.com/images/wonjongseo/post/014df634-01b5-4cea-9c3c-6134b1fa2c5f/image.png)
警告メッセージを出力します。

![](https://velog.velcdn.com/images/wonjongseo/post/b69fdd83-36ee-4928-92cc-305575277122/image.png)
![](https://velog.velcdn.com/images/wonjongseo/post/309c0952-b153-4e1a-8acc-e26734dcb214/image.png)

XMLファイルを開くと、正常に「ロードされます」というメッセージを出力します。
残りのボタンの機能も問題なく使用できます。

## Print Page


![](https://velog.velcdn.com/images/wonjongseo/post/c6127cf3-be34-42c1-aa98-820e860f6671/image.png)

現在ロードされているXMlファイルの内容を画面に出力します。
Loadされたファイルがなければ警告出力します。

## Find Page
![](https://velog.velcdn.com/images/wonjongseo/post/93ff2f18-7b83-4488-9e09-071cd4a24599/image.png)


ロードしたファイルのElement・Attribute・Textの中で、一つを検索します。



![](https://velog.velcdn.com/images/wonjongseo/post/93073220-b9b1-42f7-acda-a081fa51474e/image.png)

もし、検索した内容がなければ警告発生。

![](https://velog.velcdn.com/images/wonjongseo/post/67417012-385f-4a1d-b525-f7c433ce8223/image.png)

![](https://velog.velcdn.com/images/wonjongseo/post/3c9dbe0a-1d74-4865-8603-e488abdd52ce/image.png)
入力した情報に対する元素Tree構造で出力します。



![](https://velog.velcdn.com/images/wonjongseo/post/0c4cddd4-3a2a-4500-991c-ec1c0a20f1dd/image.png)
![](https://velog.velcdn.com/images/wonjongseo/post/2804b617-1e26-4708-ada1-916050b91f1b/image.png)


![](https://velog.velcdn.com/images/wonjongseo/post/88490324-d97a-47e1-84d6-168562564d9a/image.png)
![](https://velog.velcdn.com/images/wonjongseo/post/ceaf7161-2a32-4dc2-9850-b1731f980c07/image.png)
0個入力と保有中の元素の数より大きい数を入力すると、適切なメッセージを出力します。


![](https://velog.velcdn.com/images/wonjongseo/post/e80dc0b8-95c2-4101-b89b-beb1dca934c6/image.png)

Attributeの名前である"starbucks:height"のValueを検索します。


Findボタンを押すと、
![](https://velog.velcdn.com/images/wonjongseo/post/90906125-c6e3-4494-9fdb-fd6532fdc64f/image.png)

どのノードのプロパティを探しているのか入力されます。
![](https://velog.velcdn.com/images/wonjongseo/post/b4603d65-faae-4fe9-9a46-e9f9bd095a05/image.png)

誤った元素を入力した場合、
![](https://velog.velcdn.com/images/wonjongseo/post/29fb7534-5e4d-41b2-a695-bb796ad76a54/image.png)
警告メッセージ出力


![](https://velog.velcdn.com/images/wonjongseo/post/3e62a51c-b1af-4ccd-94ec-d1a8ec17907a/image.png)

正確な元素を入力すると、
![](https://velog.velcdn.com/images/wonjongseo/post/73ff7014-38d2-4dfc-9a72-5b1d4dcf3a93/image.png)
入力されたElementのAttributeの名前に相応するAttribute　valueを画面に出力します。


![](https://velog.velcdn.com/images/wonjongseo/post/0bd6e4dc-b890-4559-b24c-78313e494cff/image.png)

![](https://velog.velcdn.com/images/wonjongseo/post/160c2c31-43b8-4545-a7df-64804cc65d53/image.png)
最後に40番目のstarbucks-detail:kcalの子供のうち145を検索します。

![](https://velog.velcdn.com/images/wonjongseo/post/76febba1-e433-4f9d-b0c7-55f4e7512192/image.png)

一致しない情報を入力すると，


![](https://velog.velcdn.com/images/wonjongseo/post/0237849f-6778-4030-b44e-d079a22ab392/image.png)
警告出力します。

![](https://velog.velcdn.com/images/wonjongseo/post/cf61dc34-41e0-41ae-ae7f-0e91c7e13e68/image.png)

![](https://velog.velcdn.com/images/wonjongseo/post/65a1b501-8392-44e1-b5df-1a086c8995c2/image.png)


希望する情報のTEXTノードを出力します

## Make Page

新しいXmlDOMを生成するMakeボタンは、XMLをロードしなくても実行できます。


![](https://velog.velcdn.com/images/wonjongseo/post/6a01673a-d044-47a8-9872-d204f36c16bf/image.png)

新しいXMLファイルの名前を入力。

![](https://velog.velcdn.com/images/wonjongseo/post/c6b5be22-e9d7-4ed4-a84c-984edb63704c/image.png)
Makeボタンを押すと、上記のような画面が出力されます。
何も入力しないと、入力するまで上の画面を表示します。

![](https://velog.velcdn.com/images/wonjongseo/post/bd140e2e-bc4a-431f-b60a-69a2ceb07696/image.png)

例としてRootを「fruit」と入力して確認を押しますと、

![](https://velog.velcdn.com/images/wonjongseo/post/1958bc22-bfbf-4edc-8e27-9769eeaca363/image.png)

上記のような画面を表示します。


![](https://velog.velcdn.com/images/wonjongseo/post/eb0a1a25-02eb-40b1-8a3a-fa24656f3e00/image.png)

Element・Attribute・Text・Commentタイプを作成することができます。

![](https://velog.velcdn.com/images/wonjongseo/post/9d27c4b4-2fc0-4ac5-bb76-ebc00953de97/image.png)

親ノードと子ノードを入力して以来、Makeボタンをクリックします。

![](https://velog.velcdn.com/images/wonjongseo/post/b18d0d49-6e3f-47da-bce2-d7276a601001/image.png)

![](https://velog.velcdn.com/images/wonjongseo/post/f3e8301c-23af-4e60-8295-07df5f559f1c/image.png)

Elementの挿入が成功する

![](https://velog.velcdn.com/images/wonjongseo/post/3c942efa-85cb-4350-842f-4d1312f8b95e/image.png)


もちろん、存在しない親ノードの子を挿入させるときは、
![](https://velog.velcdn.com/images/wonjongseo/post/c0dfa85a-6f47-4ce6-a08e-07c7285e510a/image.png)

警告メッセージを出力します。
![](https://velog.velcdn.com/images/wonjongseo/post/b86b5156-0345-43fb-84e3-00079d17f584/image.png)


生成したappleの子でtextnodeの生成も可能です。

![](https://velog.velcdn.com/images/wonjongseo/post/f12fcd81-d793-4193-8938-1d1d6e7569d8/image.png)



![](https://velog.velcdn.com/images/wonjongseo/post/d422914f-272e-49df-8160-e59af1b5bdfb/image.png)
Attributeノード作成時、childノードに入力する値はAttributeの名前です。
値を入力してMakeボタンを押した後、

![](https://velog.velcdn.com/images/wonjongseo/post/ba3b49ce-3c30-479b-b1ea-962b5b964ab1/image.png)

Attributeのvalueまで入力されます。
![](https://velog.velcdn.com/images/wonjongseo/post/ea36ab6e-5303-4bcd-b970-4a151342d731/image.png)

fruitの子でappleをもう2つ作ります。

appleの子としてprice elementを挿入させると、

![](https://velog.velcdn.com/images/wonjongseo/post/64222d5a-1573-410a-8dcf-264c2b1d7114/image.png)



上記の画面が表示され、0以下を入力すると、
![](https://velog.velcdn.com/images/wonjongseo/post/0136be47-d9f2-4fdb-9cfe-2530d1ade807/image.png)

ノードの数より大きい数を入力しますと、
![](https://velog.velcdn.com/images/wonjongseo/post/a14a7b58-6881-4918-9cd4-b511eb5c1246/image.png)
入力を再度受け付けます。

1番に挿入させ、Priceに777Textも挿入します。
![](https://velog.velcdn.com/images/wonjongseo/post/0998edc7-9420-48fd-ac73-b9e13535baff/image.png)



ShowTreeボタンを押しますと
![](https://velog.velcdn.com/images/wonjongseo/post/968d922e-5f84-4e64-8911-f261c7d27082/image.png)


現在まで挿入したノードの状態をTree構造で確認することができます。


![](https://velog.velcdn.com/images/wonjongseo/post/c1942902-289a-4997-98b6-05c3005477ca/image.png)
![](https://velog.velcdn.com/images/wonjongseo/post/5d91fe2f-67c9-4677-b313-331b35293130/image.png)

Reloadボタンを押すと、　作業したXMLファイルでロードを再起動します。
![](https://velog.velcdn.com/images/wonjongseo/post/4f645f7d-3177-4f6f-8613-2eca90c70003/image.png)


## Save Page

Loadボタンを利用してロードしたファイルをUpdate、Delete、Insertボタンで作業するとか、Makeボタンを利用して新しいXMLDOMファイルを作成して作業を行います。

Saveボタンを押すと、

![](https://velog.velcdn.com/images/wonjongseo/post/1b1e653e-f5e6-432f-8062-cbb8e7abb038/image.png)

新しい名前でファイルを作成するかどうかを尋ねます。

「はい」押しまと、

![](https://velog.velcdn.com/images/wonjongseo/post/cc8f5c49-af07-46c7-b4d3-afba4db2ca4a/image.png)

![](https://velog.velcdn.com/images/wonjongseo/post/f8686a5c-4998-418a-af08-fdc23fa4930c/image.png)
拡張名を入力しなくても自動的に.xmlを付けてくれます。


![](https://velog.velcdn.com/images/wonjongseo/post/f4c013e5-2b61-4550-b51e-d85eac99b2b5/image.png)






きちんとファイルが生成されたことを確認できます。

## Insert Page


![](https://velog.velcdn.com/images/wonjongseo/post/fb87b7a8-501b-4010-b4ca-8242b81b5d4b/image.png)

挿入したい情報をChildノードに書き、位置をParentノードに記入します。

![](https://velog.velcdn.com/images/wonjongseo/post/186a8611-5f79-4aca-85e1-6b4a6d96371d/image.png)

確認メッセージを出力した後、
![](https://velog.velcdn.com/images/wonjongseo/post/ca9b8de3-9b5a-4017-95c4-7a6e1f35725e/image.png)

正常挿入されていることが確認できます。

![](https://velog.velcdn.com/images/wonjongseo/post/095e109d-1c35-4502-8f11-66936d6c72c1/image.png)
ElementだけでなくTextも挿入できます。


![](https://velog.velcdn.com/images/wonjongseo/post/bd8d13d7-16ea-48da-97de-eaf61a15f576/image.png)

Attributeも可能です。

![](https://velog.velcdn.com/images/wonjongseo/post/ef0af263-d394-41e1-bfc9-f6feadd76785/image.png)

Printボタンを押し、確認するときちんと挿入されたことを確認できます。

もちろんCommentの作業も可能です。

## Delete Page


![](https://velog.velcdn.com/images/wonjongseo/post/98dda5f5-a98b-4d22-bf4f-d0f66fa626b8/image.png)

最初名前のtoffee　nut　cold　brew　TEXTを削除して見ます。

![](https://velog.velcdn.com/images/wonjongseo/post/3cba3b9f-8b89-4a28-973c-a9e6e7b283e3/image.png)


![](https://velog.velcdn.com/images/wonjongseo/post/64184577-c1c1-46d7-93ef-fca5d05bcdb3/image.png)


親ノード入力する。

![](https://velog.velcdn.com/images/wonjongseo/post/27e8e024-ded4-4207-815a-623ff89d4f44/image.png)
40個の名前のelementが存在するため、何番目なのかを入力されます。

番号を入力すると、
![](https://velog.velcdn.com/images/wonjongseo/post/b926662d-1e7e-4199-bbad-66a040a97241/image.png)

というメッセージを受け、うまく作動しているかをPrintボタンの機能で確認することができます。

![](https://velog.velcdn.com/images/wonjongseo/post/0b82ae4c-52f1-43e2-b752-79384bce48d1/image.png)


## Update Page 

![](https://velog.velcdn.com/images/wonjongseo/post/01340c5e-a06a-493c-b36a-76726682ea30/image.png)

Updateボタンは、Insert及びDeleteの機能を選ぶことができます。

# Exit Page
![](https://velog.velcdn.com/images/wonjongseo/post/93e98cd9-bfd4-4be7-92ed-b1025a433bb4/image.png)

はい、ボタンの後にロードされているファイルがあればファイルを保存するのかと尋ねます。
ファイルロードされていない場合は、1.5秒後にプログラムを終了します。

![](https://velog.velcdn.com/images/wonjongseo/post/7b895eae-99a7-4d8d-a09d-9cfc7256fd32/image.png)

![](https://velog.velcdn.com/images/wonjongseo/post/79b9815f-549d-45ca-a4e9-a2f1592b73e5/image.png)


「はい」をクリックすると、新しい名前を入力してもらい、新しい名前でファイルを作成し、プログラム終了します。
「いいえ」を押すと、ロードするときに指定したファイル名でファイルを作成し、プログラム終了です。
