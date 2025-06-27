Feature: Ambil foto otomatis

  Scenario: Klik tombol kamera dan ambil gambar
    Given Pengguna membuka halaman kamera
    When Pengguna klik tombol kamera
    Then Foto berhasil diambil