Feature: Fitur Absen Masuk

  Scenario: Pengguna berhasil masuk ke halaman home dan melakukan absen
    Given Pengguna berada di halaman Home
    And Pengguna Harus mengclik button absen
    And Pengguna mengambil foto selfie dengan wajah terlihat
#    Then Muncul Form Absen
#    Then  Jam masuk otomatis muncul
#    When Pengguna memilih opsi "WFO"
#    And Pengguna menambahkan catatan "Bekerja dari kantor"
#    When Pengguna memilih opsi "WFH"
#    And Pengguna menambahkan catatan "Bekerja dari rumah"
#    And Pengguna menekan tombol Absen Masuk
#    Then Sistem menampilkan pesan "Absen masuk berhasil"