package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        registry.registerRedStampCreator("FOO", "BAR"); //빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerBlueStampCreator("FOO", "BAR");
        registry.registerGreenStampCreator("FOO", "BAR");// 녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWallCalendarCreator("FOO", "BAR");// 벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMagnetCalendarCreator("FOO", "BAR");// 자석 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDeskCalendarCreator("FOO", "BAR");// 탁상 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBannerCreator("FOO", "BAR");// 가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBannerCreator("FOO", "BAR");// 세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGlossBannerCreator("FOO", "BAR"); //반사 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerScrimBannerCreator("FOO", "BAR");//스크림 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMeshBannerCreator("FOO", "BAR");// 메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBusinessCardCreator("FOO", "BAR"); //가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBusinessCardCreator("FOO", "BAR"); //세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerIvoryBusinessCardCreator("FOO", "BAR"); //아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGrayBusinessCardCreator("FOO", "BAR"); //회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWhiteBusinessCardCreator("FOO", "BAR"); //흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLaidBusinessCardCreator("FOO", "BAR"); //레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLinenBusinessCardCreator("FOO", "BAR"); //린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmoothBusinessCardCreator("FOO", "BAR"); //스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSingleSidedBusinessCardCreator("FOO", "BAR"); //단면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDoubleSidedBusinessCardCreator("FOO", "BAR"); //양면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerCartCreator("FOO"); //장바구니를 만드는 생성자를 등록한다.
        registry.registerProductAdder("FOO", "BAR"); //장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductRemover("FOO", "BAR"); //장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerTotalPriceGetter("FOO", "BAR"); //장바구니에서 총액을 구해오는 메서드를 등록한다.
        registry.registerLandscapeBannerTextApertureAdder("FOO", "BAR"); //가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("FOO", "BAR"); //가로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerTextApertureAdder("FOO", "BAR"); //세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("FOO", "BAR"); //세로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerGlossBannerTextApertureAdder("FOO", "BAR"); //반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("FOO", "BAR"); //반사 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerScrimBannerTextApertureAdder("FOO", "BAR"); //스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("FOO", "BAR"); //스크림 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerMeshBannerTextApertureAdder("FOO", "BAR"); //메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("FOO", "BAR"); //메쉬 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinnessCardTextApertureAdder("FOO", "BAR"); //가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinnessCardImageApertureAdder("FOO", "BAR"); //가로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinnessCardTextApertureAdder("FOO", "BAR"); //세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinnessCardImageApertureAdder("FOO", "BAR"); //세로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinnessCardTextApertureAdder("FOO", "BAR"); //아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinnessCardImageApertureAdder("FOO", "BAR"); //아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerGrayBusinnessCardTextApertureAdder("FOO", "BAR"); //회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinnessCardImageApertureAdder("FOO", "BAR"); //회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinnessCardTextApertureAdder("FOO", "BAR"); //흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinnessCardImageApertureAdder("FOO", "BAR"); //흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLaidBusinnessCardTextApertureAdder("FOO", "BAR"); //레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinnessCardImageApertureAdder("FOO", "BAR"); //레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLinenBusinnessCardTextApertureAdder("FOO", "BAR"); //린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinnessCardImageApertureAdder("FOO", "BAR"); //린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinnessCardTextApertureAdder("FOO", "BAR"); //스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinnessCardImageApertureAdder("FOO", "BAR"); //스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinnessCardTextApertureAdder("FOO", "BAR"); //단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinnessCardImageApertureAdder("FOO", "BAR"); //단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("FOO", "BAR"); //양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("FOO", "BAR"); //양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}
