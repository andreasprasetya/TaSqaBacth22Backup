Feature: Authentication feature test
  @PriorityTinggi
  Scenario Outline: Login dengan kredensial yang valid
    Given Buka halaman login untuk pengujian login valid
    When Masukkan username "<username>" dan password "<password>" valid
    And Klik tombol login untuk login valid
    Then Pengguna berhasil masuk ke halaman absen

    Examples:
      | username      | password     |
      | hadirsqa1@gmail.com | SQA@Hadir12345 |
#     |komar@gmail.com | Komar123 |

  Scenario Outline: Login dengan kredensial yang tidak valid
    Given Buka halaman login untuk pengujian login invalid
    When Masukkan username "<username>" dan password "<password>" tidak valid
    And Klik tombol login untuk login tidak valid
#    Then Pengguna akan melihat pesan error

    Examples:
      | username       | password       |
      | emailtidakada@gmail.com | SQA@Hadir12345 |
      | hadirsqa1gmail.com  | SQA@Hadir12345 |
      | hadirsqa1@gmail.com | SQA@Hadir123456789|
      | hadirsqa1@gmail.com |  |
      |   | SQA@Hadir12345|
      | | |

   Scenario: Logout dari halaman Home
    Given User sudah masuk ke dalam halam home
    When Klik menu bar
    And Tunggu sampai muncul side bar
    Then Klik Button logout