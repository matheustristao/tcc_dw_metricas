#!/usr/bin/env ruby
require 'csv'
require 'json'

if ARGV.size != 2
  puts 'Forma de Utilizar: parserCSVJSON input_file.csv output_file.json'
  exit(1)
end

lines = CSV.open(ARGV[0]).readlines
keys = lines.delete lines.first

File.open(ARGV[1], 'w') do |f|
  data = lines.map do |values|
    Hash[keys.zip(values)]
  end
  f.puts JSON.pretty_generate(data)
end
