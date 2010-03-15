def combo2(arrays, num)
  arrays.map do |a|
    num_before = num
    v = a[num % a.length]
    num /= a.length
#    puts "a: #{a.inspect} num before: #{num_before} num after: #{num} l: #{a.length} v: #{v}"
    v
  end
end

def decode(arrays, string)
  parts = string.split('-')
  multiplier = 1
  sum = 0
  parts.each_with_index do |p, i|
    v = (arrays[i].index(p) * multiplier)
    multiplier *= arrays[i].length
    sum += v
  end
  sum
end

def test(arrays)
  puts "-"*20
  puts arrays.inspect
  total = arrays.map{|x| x.length}.inject{|m,x| m*x}
  results = (0..total-1).map {|i| combo2(arrays, i)}
  decodes = results.map{|r| r.join("-")}.zip((0..results.size-1).to_a).all? do |r|
    if r.last == decode(arrays, r.first)
      true
    else
      puts "XXX: #{r.first} should: #{r.last} is: #{decode(arrays, r.first)}"
    end
  end
  puts "Total: #{total}, Count: #{total == results.size}, Uniq: #{results.uniq.size == total}, Decoded All: #{decodes}"
#  puts results.inspect
end

#a = [('0'..'2').to_a] * 2
#a = [%w[0 1 2], %w[0 1], %w[0 1]]
#test(a)
#puts "The fifth postion is: " + combo2(a, 5).inspect
#puts decode(a, "2-1-0")
#exit

test [%w[1],%w[2]]
test [%w[1],%w[2 3]]
test [%w[1 2],%w[3]]
test [%w[1 2],%w[3 4 5]]
test [%w[1 2],%w[3 4], %w[5 6]]
test [%w[1 2 3 4],%w[6 7],%w[8 9 10]]
test [%w[1 2 3],%w[4 5]]
test [%w[1 2 3 4 5 6], %w[7 8 9 10 11], %w[12]]
